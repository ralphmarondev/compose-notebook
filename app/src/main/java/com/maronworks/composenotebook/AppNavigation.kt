package com.maronworks.composenotebook

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maronworks.composenotebook.features.instagram_mini.InstagramMini
import com.maronworks.composenotebook.home.HomeScreen

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object InstagramMini : Screen("instagram_mini")
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(Screen.InstagramMini.route) {
                InstagramMini(navController = navController)
            }
        }
    }
}