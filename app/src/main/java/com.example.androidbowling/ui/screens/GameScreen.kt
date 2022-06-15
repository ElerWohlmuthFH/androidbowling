package com.example.androidbowling.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbowling.ui.common.*
import com.example.androidbowling.ui.theme.AndroidBowlingTheme

@Composable
fun GameScreen(
    popBackStack: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Game", fontSize = 40.sp)

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "This app was made by Eler and Matthias")

        Frames()


        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Player("Eler")
            Player("Matthias")
            Player("Eler")
            Player("Matthias")
            Player("Eler")
            Player("Matthias")
        }
        NumPad()

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