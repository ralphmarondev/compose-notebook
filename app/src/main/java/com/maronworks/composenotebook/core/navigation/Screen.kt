package com.maronworks.composenotebook.core.navigation

sealed class Screen(val route: String) {
    data object OnBoarding : Screen("on_boarding")
    data object Login : Screen("login")
    data object Home : Screen("home")
}