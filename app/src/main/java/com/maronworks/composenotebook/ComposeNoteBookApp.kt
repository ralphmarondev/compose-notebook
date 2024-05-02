package com.maronworks.composenotebook

import android.os.Build
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maronworks.composenotebook.core.navigation.AppNavigation
import com.maronworks.composenotebook.core.util.splash.SplashScreen
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

@Composable
fun ComposeNoteBookApp() {
    ComposeNotebookTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) "splash" else "main"
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