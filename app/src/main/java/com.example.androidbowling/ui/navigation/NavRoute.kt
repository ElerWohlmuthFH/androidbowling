package com.example.androidbowling.ui.navigation

sealed class NavRoute(val path: String) {

    object Home : NavRoute("home")

    object GameSettings : NavRoute("gameSettings")

    object Statistics : NavRoute("statistics")

    object About : NavRoute("about")

    object Game : NavRoute("game")
}




