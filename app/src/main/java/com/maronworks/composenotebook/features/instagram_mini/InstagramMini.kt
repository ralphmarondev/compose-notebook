package com.maronworks.composenotebook.features.instagram_mini

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.VideoLibrary
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.maronworks.composenotebook.features.instagram_mini.presentation.home.HomeScreen
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

val instagramMiniVM = InstagramMiniViewModel()

@Preview
@Composable
private fun Default() {
    ComposeNotebookTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            InstagramMini(rememberNavController())
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InstagramMini(
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            InstagramMiniBottomBar()
        }
    ) {
        HomeScreen(
            onExit = {
                instagramMiniVM.exitInstagramMini(navController)
            }
        )
    }
}

@Composable
private fun InstagramMiniBottomBar() {
    val bottomItems = listOf(
        Icons.Outlined.Home,
        Icons.Outlined.Search,
        Icons.Outlined.AddBox,
        Icons.Outlined.VideoLibrary,
        Icons.Outlined.AccountCircle
    )

    NavigationBar {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            bottomItems.forEachIndexed { index, imageVector ->
                NavigationBarItem(
                    selected = instagramMiniVM.isSelected(index),
                    onClick = { instagramMiniVM.setSelectedIndex(index) },
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
}