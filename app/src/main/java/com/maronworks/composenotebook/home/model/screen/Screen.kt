package com.maronworks.composenotebook.home.model.screen

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Recent: Screen("recent_screen")
    data object Notification: Screen("notification_screen")
    data object Profile: Screen("profile_screen")
}