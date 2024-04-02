package com.maronworks.composenotebook.core.navigation

sealed class Screen(val route: String) {
    data object OnBoarding : Screen("on_boarding")
    data object Home : Screen("home")
    data object InstagramMini : Screen("instagram_mini")
    data object TodoApp: Screen("todo_app")
}