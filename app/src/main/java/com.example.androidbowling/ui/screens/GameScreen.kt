package com.example.androidbowling.ui.screens


import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidbowling.ui.rooms.*
import com.example.androidbowling.ui.theme.AndroidBowlingTheme
import com.example.androidbowling.ui.common.Player

@Composable
fun GameScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Game", fontSize = 40.sp)

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "This app was made by Eler and Matthias")


        //model.clear()
        val context = LocalContext.current
        val model: PlayerListViewModel = viewModel(
            factory = PlayerListViewmodelFactory(
                context.applicationContext as Application
            )
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            val players: List<Player> = model.playerListList.observeAsState(listOf()).value

            for (player in players) {
                Player(name = player.name)
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    AndroidBowlingTheme(useSystemUiController = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
        }
    }
}