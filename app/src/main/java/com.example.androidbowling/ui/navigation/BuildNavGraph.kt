package com.example.androidbowling.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.androidbowling.ui.screens.AboutScreen
import com.example.androidbowling.ui.screens.HomeScreen
import com.example.androidbowling.ui.screens.ProfileScreen
import com.example.androidbowling.ui.screens.SearchScreen

@Composable
fun BuildNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path
    ) {
        addHomeScreen(navController, this)
        addProfileScreen(navController, this)
        addSearchScreen(navController, this)
        addAboutScreen(navController, this)
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {

        HomeScreen(
            navigateToProfile = { id, showDetails ->
                navController.navigate(
                    NavRoute.Profile.withArgs(
                        id.toString(),
                        showDetails.toString()
                    )
                )
            },
            navigateToSearch = { query ->
                navController.navigate(NavRoute.Search.withArgs(query))
            },

            ) { query ->
            navController.navigate(NavRoute.About.withArgs(query))
        }
    }
}

private fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.withArgsFormat(NavRoute.Profile.id, NavRoute.Profile.showDetails),
        arguments = listOf(
            navArgument(NavRoute.Profile.id) {
                type = NavType.IntType
            },
            navArgument(NavRoute.Profile.showDetails) {
                type = NavType.BoolType
            }
        )
    ) { navBackStackEntry ->

        val args = navBackStackEntry.arguments

        ProfileScreen { navController.popBackStack() }
    }
}

private fun addSearchScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Search.withArgsFormat(NavRoute.Search.query),
        arguments = listOf(
            navArgument(NavRoute.Search.query) {
                type = NavType.StringType
                nullable = true
            }
        )
    ) { navBackStackEntry ->
        navBackStackEntry.arguments
        SearchScreen { navController.popBackStack() }
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
