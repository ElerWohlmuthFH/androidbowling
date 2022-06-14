package com.example.androidbowling.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbowling.ui.common.DefaultButton
import com.example.androidbowling.ui.theme.AndroidBowlingTheme

@Composable
fun AboutScreen(
    popBackStack: () -> Unit,
) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("About", fontSize = 40.sp)

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "This app was made by Eler and Matthias")

        DefaultButton(
            text = "Back",
            onClick = popBackStack
        )
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