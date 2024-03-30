package com.maronworks.guessing_game

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maronworks.guessing_game.data.datastore.SharedPreferencesManager
import com.maronworks.guessing_game.home.HomeScreen
import com.maronworks.guessing_game.onboarding.OnBoardingScreen

sealed class Screen(val route: String) {
    data object OnBoarding : Screen("onboarding")
    data object Home : Screen("home")
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    sharedPref: SharedPreferencesManager
) {
    val startDestination =
        if (sharedPref.isFirstLaunch()) Screen.OnBoarding.route
        else Screen.Home.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.OnBoarding.route) {
            OnBoardingScreen(
                onGetStartedClick = {
                    sharedPref.setPreference()
                    navController.popBackStack()
                    navController.navigate(Screen.Home.route)
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen()
        }
    }
}