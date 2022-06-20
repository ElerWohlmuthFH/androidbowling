package com.example.androidbowling.ui.screens


import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidbowling.R
import com.example.androidbowling.ui.rooms.*
import com.example.androidbowling.ui.theme.AndroidBowlingTheme
import com.example.androidbowling.ui.common.Player

@Composable
fun GameScreen() {

    val context = LocalContext.current
    val model: PlayerListViewModel = viewModel(
        factory = PlayerListViewmodelFactory(
            context.applicationContext as Application
        )
    )

    val tableData = (1..1).mapIndexed { index, _ ->
        index to "Item $index"
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        items(tableData) {
            Spacer(modifier = Modifier.height(5.dp))

//            Text(
//                text = "Bowling Score Tracker",
//                fontSize = 40.sp
//            )

                Image(
                    painter = painterResource(id = R.drawable.top_image),
                    contentDescription = null,
                    Modifier.height(80.dp),
                    alignment = Alignment.Center
                )

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