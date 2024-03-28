package com.maronworks.composenotebook.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maronworks.composenotebook.home.HomeScreen
import com.maronworks.composenotebook.profile.ProfileScreen

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Profile : Screen("profile_screen")
}

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }
    }
}