package com.maronworks.composenotebook.core.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maronworks.composenotebook.MainViewModel
import com.maronworks.composenotebook.features.instagram_mini.InstagramMini
import com.maronworks.composenotebook.home.HomeScreen
import com.maronworks.composenotebook.onboarding.OnBoardingScreen

// this variable is accessible in the whole app
val mainViewModel = MainViewModel()

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

    Scaffold {
        NavHost(
            navController = navController,
            startDestination = mainViewModel.getStartDestination(context)
        ) {
            composable(Screen.OnBoarding.route) {
                OnBoardingScreen(
                    onGetStarted = {
                        navController.popBackStack()
                        navController.navigate(Screen.Home.route)
                    }
                )
            }
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(Screen.InstagramMini.route) {
                InstagramMini(navController = navController)
            }
        }
    }
}