package com.example.androidbowling.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidbowling.R
import com.example.androidbowling.ui.common.HomeScreenButton
import com.example.androidbowling.ui.theme.AndroidBowlingTheme
import com.example.androidbowling.ui.theme.PrimaryRed

@Composable
fun HomeScreen(
    navigateToGameSettings: () -> Unit,
    navigateToStatistics: () -> Unit,
    navigateToAbout: () -> Unit,
) {

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(PrimaryRed),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = R.drawable.bowling), contentDescription = null, Modifier.size(300.dp))


        HomeScreenButton(
            text = "New Game"
        ) { navigateToGameSettings() }

        HomeScreenButton(
            text = "Statistics"
        ) { navigateToStatistics() }

        HomeScreenButton(
            text = "Rules"
        ) { navigateToAbout() }

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
                navigateToGameSettings = {},
                navigateToStatistics = {}
            ) {}
       }
    }
}