package com.example.androidbowling.ui.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.androidbowling.ui.screens.AboutScreen
import com.example.androidbowling.ui.screens.HomeScreen
import com.example.androidbowling.ui.screens.GameSettingsScreen
import com.example.androidbowling.ui.screens.StatisticsScreen

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
        addGameSettingsScreen(this, scaffoldState)
        addStatisticsScreen(navController, this)
        addAboutScreen(navController, this)
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {

        HomeScreen(
            navigateToGameSettings = { id, showDetails ->
                navController.navigate(
                    NavRoute.GameSettings.withArgs(
                        id.toString(),
                        showDetails.toString()
                    )
                )
            },
            navigateToStatistics = { query ->
                navController.navigate(NavRoute.Statistics.withArgs(query))
            },

            ) { query ->
            navController.navigate(NavRoute.About.withArgs(query))
        }
    }
}

private fun addGameSettingsScreen(
    navGraphBuilder: NavGraphBuilder,
    scaffoldState: ScaffoldState

) {
    navGraphBuilder.composable(
        route = NavRoute.GameSettings.withArgsFormat(
            NavRoute.GameSettings.id,
            NavRoute.GameSettings.showDetails
        ),
        arguments = listOf(
            navArgument(NavRoute.GameSettings.id) {
                type = NavType.IntType
            },
            navArgument(NavRoute.GameSettings.showDetails) {
                type = NavType.BoolType
            }
        )
    ) { navBackStackEntry ->

        navBackStackEntry.arguments

        GameSettingsScreen(scaffoldState)
    }
}

private fun addStatisticsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Statistics.withArgsFormat(NavRoute.Statistics.query),
        arguments = listOf(
            navArgument(NavRoute.Statistics.query) {
                type = NavType.StringType
                nullable = true
            }
        )
    ) { navBackStackEntry ->
        navBackStackEntry.arguments
        StatisticsScreen { navController.popBackStack() }
    }
}

private fun addAboutScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.About.withArgsFormat(NavRoute.About.query),
        arguments = listOf(
            navArgument(NavRoute.About.query) {
                type = NavType.StringType
                nullable = true
            }
        )
    ) { navBackStackEntry ->
        navBackStackEntry.arguments
        AboutScreen { navController.popBackStack() }
    }
}
