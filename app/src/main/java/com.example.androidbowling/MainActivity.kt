package com.example.androidbowling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.androidbowling.ui.navigation.BuildNavGraph
import com.example.androidbowling.ui.theme.AndroidBowlingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    AndroidBowlingTheme {
        val navController = rememberNavController()
        val scaffoldState: ScaffoldState = rememberScaffoldState(
            snackbarHostState = SnackbarHostState()
        )
        BuildNavGraph(navController)
    }
}
