package com.maronworks.composenotebook.mini_apps.converter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.maronworks.composenotebook.mini_apps.converter.ui.theme.ComposeNotebookTheme

class ConverterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNotebookTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Converter Activity Lol")

                        Button(
                            onClick = {
                                finish() // to navigate back to MainActivity.kt
                            },
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                        ) {
                            Text(text = "Navigate back")
                        }
                    }
                }
            }
        }
    }
}