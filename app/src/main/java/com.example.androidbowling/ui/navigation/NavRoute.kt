package com.example.androidbowling.ui.navigation

sealed class NavRoute(val path: String) {

    object Home : NavRoute("home")

    object GameSettings : NavRoute("gameSettings") {
        val id = "id"
        val showDetails = "showDetails"
    }

    object Statistics : NavRoute("statistics") {
        val query = "query"
    }

    object About : NavRoute("about") {
        val query = "query"
    }

    // build navigation path (for screen navigation)
    fun withArgs(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    // build and setup route format (in navigation graph)
    fun withArgsFormat(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach { arg ->
                append("/{$arg}")
            }
        }
    }
}


