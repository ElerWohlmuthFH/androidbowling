package com.example.androidbowling.ui.screens

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidbowling.ui.common.StartGameButton
import com.example.androidbowling.ui.common.PlayerListButton
import com.example.androidbowling.ui.rooms.Player
import com.example.androidbowling.ui.rooms.PlayerListViewmodelFactory
import com.example.androidbowling.ui.rooms.PlayerListViewModel
import com.example.androidbowling.ui.theme.PrimaryGrey
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun GameSettingsScreen(
    scaffoldState: ScaffoldState,
    navigateToGame: () -> Unit
) {


    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val model: PlayerListViewModel = viewModel(
        factory = PlayerListViewmodelFactory(
            context.applicationContext as Application
        )
    )
    val list: List<Player> = model.playerListList.observeAsState(listOf()).value
    var textState = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        //contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp),

                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFFFFF),
                    focusedIndicatorColor = Color.Transparent, //hide the indicator
                ),
                value = textState.value, onValueChange = { textState.value = it },
                placeholder = {
                    Text(text = "Enter Name")
                },
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                PlayerListButton(
                    text = "add Name",
                    onClick = {
                        model.insert(
                            Player(
                                null,
                                UUID.randomUUID().toString(),
                                textState.value
                            )
                        )
                        scope.launch {
                            textState.value = ""
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = "Notes added",
                            )
                        }
                    })
                PlayerListButton(
                    text = "clear All",
                    onClick = {
                        model.clear()
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = "All Names deleted",
                            )
                        }

                    })
            }
            Column() {
                StartGameButton(
                    text = "Start Game",
                    onClick = navigateToGame
                )
            }



            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                items(list.size) { index ->
                        Row(
                            modifier = Modifier.padding(4.dp).background(PrimaryGrey),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${list[index].id}",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 12.dp),
                                color = Color.Black
                            )

//                            Text(
//                                text = " : " + list[index].fullName.take(10),
//                            )

                            Text(
                                text = " : " + list[index].name,
                                style = TextStyle(
                                    color = Color.Black
                                ),
                                modifier = Modifier.weight(2F)
                            )

                            IconButton(onClick = {
                                list[index].name = textState.value
                                model.update(list[index])
                                scope.launch {
                                    scaffoldState.snackbarHostState
                                        .showSnackbar(
                                            "Names updated id" +
                                                    " : ${list[index].id}",
                                        )
                                    textState.value = ""
                                }
                            }) {
                                Icon(Icons.Filled.Edit, "", tint = Color.Black)
                            }

                            IconButton(onClick = {
                                model.delete(list[index])
                                scope.launch {
                                    scaffoldState.snackbarHostState
                                        .showSnackbar(
                                            "Notes deleted id" +
                                                    " : ${list[index].id}",
                                        )
                                    textState.value = ""
                                }

                            }) {
                                Icon(Icons.Filled.Delete, "", tint = Color.Red)
                            }
                        }
                    }
            }
        }
    }
}