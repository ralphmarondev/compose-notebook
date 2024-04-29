package com.maronworks.composenotebook.mini_apps.instagram.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VideoLibrary
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maronworks.composenotebook.mini_apps.instagram.home.HomeActivity
import com.maronworks.composenotebook.mini_apps.instagram.util.model.NavItemModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InstagramAppNavigation(
    navController: NavHostController = rememberNavController(),
    onExitApp: () -> Unit,
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            val listOfNavItems = listOf(
                NavItemModel(
                    defaultIcon = Icons.Outlined.Home,
                    selectedIcon = Icons.Filled.Home,
                    label = "Home",
                    onClick = {
                        navController.navigate(InstagramScreen.Home.route)
                    }
                ),
                NavItemModel(
                    defaultIcon = Icons.Outlined.Search,
                    selectedIcon = Icons.Filled.Search,
                    label = "Search",
                    onClick = {
                        navController.navigate(InstagramScreen.Search.route)
                    }
                ),
                NavItemModel(
                    defaultIcon = Icons.Outlined.AddBox,
                    selectedIcon = Icons.Filled.AddBox,
                    label = "Add",
                    onClick = {
                        navController.navigate(InstagramScreen.Add.route)
                    }
                ),
                NavItemModel(
                    defaultIcon = Icons.Outlined.VideoLibrary,
                    selectedIcon = Icons.Filled.VideoLibrary,
                    label = "Reels",
                    onClick = {
                        navController.navigate(InstagramScreen.Reels.route)
                    }
                ),
                NavItemModel(
                    defaultIcon = Icons.Outlined.AccountCircle,
                    selectedIcon = Icons.Filled.AccountCircle,
                    label = "Profile",
                    onClick = {
                        navController.navigate(InstagramScreen.Profile.route)
                    }
                )
            )

            NavigationBar {
                listOfNavItems.forEachIndexed { index, itemModel ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                            navController.popBackStack()
                            itemModel.onClick()
                        },
                        icon = {
                            Icon(
                                imageVector = if (selectedIndex == index) itemModel.selectedIcon
                                else itemModel.defaultIcon,
                                contentDescription = itemModel.label
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = InstagramScreen.Home.route,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable(InstagramScreen.Home.route) {
                HomeActivity(
                    onExitApp = onExitApp
                )
            }
            composable(InstagramScreen.Search.route) {
                TempScreen(destination = "Search")
            }
            composable(InstagramScreen.Add.route) {
                TempScreen(destination = "Add")
            }
            composable(InstagramScreen.Reels.route) {
                TempScreen(destination = "Reels")
            }
            composable(InstagramScreen.Profile.route) {
                TempScreen(destination = "Profile")
            }
        }
    }
}

@Composable
fun TempScreen(
    destination: String,
    background: Color = MaterialTheme.colorScheme.background,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = destination,
            modifier = Modifier
                .padding(15.dp),
            fontSize = 20.sp
        )
    }
}