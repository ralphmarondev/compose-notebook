package com.maronworks.composenotebook.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maronworks.composenotebook.home.features.login.SampleLoginScreen
import com.maronworks.composenotebook.home.features.material.cards.CardDemo

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object CardScreen : Screen("card")
    data object SampleLogin: Screen("sample_login")
}

@Composable
fun HomeNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.CardScreen.route) {
            CardDemo(onExit = { navController.popBackStack() })
        }
        composable(Screen.SampleLogin.route){
            SampleLoginScreen(navController = navController)
        }
    }
}