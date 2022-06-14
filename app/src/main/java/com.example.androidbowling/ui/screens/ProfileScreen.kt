package com.example.androidbowling.ui.screens

import android.app.Application
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
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun GetScaffold(){
    val scaffoldState: ScaffoldState = rememberScaffoldState(
        snackbarHostState = SnackbarHostState()
    )
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "BowlingApp",color= Color.White) },
                backgroundColor = Color(0xFFFDA433),
            )
        },
        content = { ProfileScreen(scaffoldState) },
        backgroundColor = Color(0xFFBEEFF5),
    )
}

@Composable
fun ProfileScreen(scaffoldState: ScaffoldState){
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val model : TodoViewModel = viewModel(
        factory = ToDoViewmodelFactory(
            context.applicationContext as Application
        )
    )
    val list:List<ToDo> = model.todoList.observeAsState(listOf()).value
    var textState = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        //contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(8.dp,),

                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFFFFF),
                    focusedIndicatorColor =  Color.Transparent, //hide the indicator
                ),
                value =textState.value, onValueChange ={textState.value = it}
                ,placeholder = {
                    Text(text = "Enter Names")
                },)

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ){
                Button(

                    onClick = {
                        model.insert(
                            ToDo(
                                null,
                                UUID.randomUUID().toString(),
                                textState.value
                            )
                        )
                        scope.launch{
                            textState.value= ""
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = "Notes added",
                            )
                        }
                    }) {
                    Text(text = "Add Names")
                }
                Button(onClick = {
                    model.clear()
                    scope.launch{
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = "All Names deleted",
                        )
                    }

                }) {
                    Text(text = "Clear")
                }
            }

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                items(list.size) { index ->
                    Card(
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxWidth()
                            .wrapContentHeight(Alignment.CenterVertically)
                    ) {
                        Row(
                            modifier = Modifier.padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${list[index].id}",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 12.dp)
                            )

                            Text(
                                text = " : " + list[index].fullName.take(10),
                            )

                            Text(
                                text = " : " + list[index].notes,
                                style = TextStyle(
                                    color = if (list[index].id!! >= 33)
                                        Color(0xFF3B7A57)
                                    else Color(0xFFAB274F)
                                ),
                                modifier = Modifier.weight(2F)
                            )

                            IconButton(onClick = {
                                list[index].notes = textState.value
                                model.update(list[index])
                                scope.launch{
                                    scaffoldState.snackbarHostState
                                        .showSnackbar(
                                            "Names updated id" +
                                                    " : ${list[index].id}",
                                        )
                                    textState.value= ""
                                }
                            }) {
                                Icon(Icons.Filled.Edit,"",tint = Color.Magenta)
                            }

                            IconButton(onClick = {
                                model.delete(list[index])
                                scope.launch{
                                    scaffoldState.snackbarHostState
                                        .showSnackbar(
                                            "Notes deleted id" +
                                                    " : ${list[index].id}",
                                        )
                                    textState.value= ""
                                }

                            }) {
                                Icon(Icons.Filled.Delete,"",tint = Color.Red)
                            }
                        }
                    }
                }
            }
        }
    }
}

/*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.androidbowling.ui.theme.SimpleNavComposeAppTheme

@Composable
fun ProfileScreen(
    popBackStack: () -> Unit,
) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Game Setting", fontSize = 40.sp)
        Text(text = "Input Player Names:")

        DefaultButton(
            text = "Start",
            onClick = popBackStack
        )

        DefaultButton(
            text = "Back",
            onClick = popBackStack
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    SimpleNavComposeAppTheme(useSystemUiController = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ProfileScreen {}
        }
    }
}

*/