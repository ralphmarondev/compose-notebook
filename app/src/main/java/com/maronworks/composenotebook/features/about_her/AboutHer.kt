package com.maronworks.composenotebook.features.about_her

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

/*
 * Contents:
 *      Rant and everything about her
 *      Screenshot every notification from her [that makes my heart feel flattered]
 *      Some notes of the things she like and about her.
 */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AboutHer() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(text = "About Her")
                }
            )
        }
    ) {
        
    }
}