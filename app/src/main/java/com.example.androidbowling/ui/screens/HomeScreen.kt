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
import com.example.androidbowling.ui.theme.SimpleNavComposeAppTheme

@Composable
fun HomeScreen(
    navigateToProfile: (Int, Boolean) -> Unit,
    navigateToSearch: (String) -> Unit,
    navigateToAbout: (String) -> Unit,
) {

    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("BowlingApp", fontSize = 40.sp)

        DefaultButton(
            text = "New Game"
        ) { navigateToProfile(7, true) }

        DefaultButton(
            text = "Statistics"
        ) { navigateToSearch("test") }

        DefaultButton(
            text = "About"
        ) { navigateToAbout("test") }

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
            HomeScreen(
                navigateToProfile = { _, _ -> },
                navigateToSearch = {}
            ) {}
       }
    }
}