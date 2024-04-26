package com.maronworks.composenotebook.core.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maronworks.composenotebook.authentication.LoginSignUpActivity
import com.maronworks.composenotebook.core.data.local.preferences.SharedPreferenceManager
import com.maronworks.composenotebook.home.HomeActivity
import com.maronworks.composenotebook.onboarding.OnBoardingActivity

@Composable
fun AppNavigation(
    context: Context = LocalContext.current,
    navController: NavHostController,
) {
    val sharedPreference = SharedPreferenceManager(context)
    val startDestination =
        if (sharedPreference.isFirstLaunch()) Screen.OnBoarding.route else Screen.Login.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.OnBoarding.route) {
            OnBoardingActivity(
                onGetStarted = {
                    // save to preference [on-boarding complete]
                    sharedPreference.setOnBoardingCompleted()

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