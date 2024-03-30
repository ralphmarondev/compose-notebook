package com.maronworks.guessing_game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.maronworks.guessing_game.data.datastore.SharedPreferencesManager
import com.maronworks.guessing_game.ui.theme.GuessingGameTheme

class GuessingGameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessingGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val sharedPref = SharedPreferencesManager(this)

                    AppNavigation(
                        navController = navController,
                        sharedPref = sharedPref
                    )
                }
            }
        }
    }
}