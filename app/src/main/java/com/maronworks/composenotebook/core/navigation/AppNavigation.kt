package com.maronworks.composenotebook.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maronworks.composenotebook.authentication.LoginSignUpActivity
import com.maronworks.composenotebook.home.HomeActivity
import com.maronworks.composenotebook.onboarding.OnBoardingActivity

@Composable
fun AppNavigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.OnBoarding.route
    ) {
        composable(Screen.OnBoarding.route) {
            OnBoardingActivity(
                onGetStarted = {
                    navController.popBackStack()
                    navController.navigate(Screen.Login.route)
                }
            )
        }
        composable(Screen.Login.route) {
            LoginSignUpActivity(
                onLogin = {
                    navController.popBackStack()
                    navController.navigate(Screen.Home.route)
                }
            )
        }
        composable(Screen.Home.route) {
            HomeActivity()
        }
    }
}