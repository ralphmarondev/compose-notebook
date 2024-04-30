package com.maronworks.composenotebook

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maronworks.composenotebook.core.navigation.AppNavigation
import com.maronworks.composenotebook.core.util.splash.SplashScreen
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNotebookTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = if (VERSION.SDK_INT < VERSION_CODES.S) "splash" else "main"
                    ) {
                        composable("splash") {
                            SplashScreen(
                                afterSplash = {
                                    navController.popBackStack()
                                    navController.navigate("main")
                                }
                            )
                        }
                        composable("main") {
                            AppNavigation()
                        }
                    }
                }
            }
        }
    }
}