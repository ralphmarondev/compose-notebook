package com.maronworks.composenotebook

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme
import com.maronworks.guessing_game.GuessingGameActivity

class MainActivity : ComponentActivity() {
    private val startNewActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNotebookTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    AppNavigation()

                    startNewActivity.launch(
                        Intent(this, GuessingGameActivity::class.java)
                    )
                }
            }
        }
    }
}
