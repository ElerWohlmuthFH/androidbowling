package com.example.androidbowling.ui.screens

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