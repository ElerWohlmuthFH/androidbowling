package com.example.androidbowling.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.androidbowling.ui.common.DefaultButton
import com.example.androidbowling.ui.theme.AndroidBowlingTheme

@Composable
fun HomeScreen(
    navigateToGameSettings: (Int, Boolean) -> Unit,
    navigateToStatistics: (String) -> Unit,
    navigateToAbout: (String) -> Unit,
) {

    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("BowlingApp", fontSize = 40.sp)

        DefaultButton(
            text = "New Game"
        ) { navigateToGameSettings(7, true) }

        DefaultButton(
            text = "Statistics"
        ) { navigateToStatistics("test") }

        DefaultButton(
            text = "About"
        ) { navigateToAbout("test") }

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
            HomeScreen(
                navigateToGameSettings = { _, _ -> },
                navigateToStatistics = {}
            ) {}
       }
    }
}