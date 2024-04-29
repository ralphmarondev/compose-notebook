package com.maronworks.composenotebook.mini_apps.instagram.navigation

sealed class InstagramScreen(val route: String) {
    data object Home : InstagramScreen("home")
    data object Search : InstagramScreen("search")
    data object Add : InstagramScreen("add")
    data object Reels : InstagramScreen("reels")
    data object Profile : InstagramScreen("profile")
}