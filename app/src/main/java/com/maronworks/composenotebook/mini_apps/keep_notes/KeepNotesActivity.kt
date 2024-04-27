package com.maronworks.composenotebook.mini_apps.keep_notes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.maronworks.composenotebook.mini_apps.keep_notes.navigation.KeepNotesNavigation
import com.maronworks.composenotebook.mini_apps.keep_notes.ui.theme.ComposeNotebookTheme

class KeepNotesActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = KeepNotesViewModel(this)

            ComposeNotebookTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // finish() -> used to finish this activity, going back to the previous activity
                    KeepNotesNavigation(
                        exitApp = { finish() },
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}