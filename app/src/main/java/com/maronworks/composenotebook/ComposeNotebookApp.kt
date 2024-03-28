package com.maronworks.composenotebook

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maronworks.composenotebook.home.HomeScreen
import com.maronworks.composenotebook.profile.ProfileScreen
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ComposeNoteBookApp() {
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            val bottomBarItems = listOf(
                Icons.Outlined.Home,
                Icons.Outlined.AccountCircle
            )

            NavigationBar {
                bottomBarItems.forEachIndexed { index, imageVector ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(
                                imageVector = imageVector,
                                contentDescription = ""
                            )
                        }
                    )
                }
            }
        }
    ) {
        when (selectedIndex) {
            0 -> HomeScreen()
            1 -> ProfileScreen()
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    ComposeNotebookTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ComposeNoteBookApp()
        }
    }
}