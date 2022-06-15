package com.example.androidbowling.ui.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidbowling.ui.screens.*

@Composable
fun BuildNavGraph(navController: NavHostController) {
    val scaffoldState: ScaffoldState = rememberScaffoldState(
        snackbarHostState = SnackbarHostState()
    )
    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path
    ) {
        addHomeScreen(navController, this)
        addGameSettingsScreen(navController, this, scaffoldState)
        addStatisticsScreen(this)
        addAboutScreen(this)
        addGameScreen(this)
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {
        HomeScreen(
            navigateToAbout = {
                navController.navigate(NavRoute.About.path)
            },
            navigateToStatistics = {
                navController.navigate(NavRoute.Statistics.path)
            },
            navigateToGameSettings = {
                navController.navigate(NavRoute.GameSettings.path)
            }
        )
    }
}

private fun addGameSettingsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    scaffoldState: ScaffoldState

) {

    navGraphBuilder.composable(
        route = NavRoute.GameSettings.path
    ) {
        GameSettingsScreen(scaffoldState = scaffoldState,
            navigateToGame = { navController.navigate(NavRoute.Game.path)})
    }

}


private fun addStatisticsScreen(
    navGraphBuilder: NavGraphBuilder
) {

    navGraphBuilder.composable(
        route = NavRoute.Statistics.path
    ) {
        StatisticsScreen {
//        popBackStack = { navController.popBackStack() }
        }
    }
}

private fun addAboutScreen(
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.About.path
    ) {
        AboutScreen {
//        popBackStack = { navController.popBackStack() }
        }
    }
}


private fun addGameScreen(
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Game.path
    ) {
        GameScreen {
//        popBackStack = { navController.popBackStack() }
        }
    }
}