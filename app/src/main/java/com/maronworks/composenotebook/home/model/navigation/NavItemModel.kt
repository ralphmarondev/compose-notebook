package com.maronworks.composenotebook.home.model.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Preview
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Preview
import androidx.compose.ui.graphics.vector.ImageVector
import com.maronworks.composenotebook.home.model.screen.Screen

data class NavItemModel(
    val defaultIcon: ImageVector,
    val selectedIcon: ImageVector,
    val route: String,
)

val listOfNavItems = listOf(
    NavItemModel(
        defaultIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        route = Screen.Home.route
    ),
    NavItemModel(
        defaultIcon = Icons.Outlined.Preview,
        selectedIcon = Icons.Filled.Preview,
        route = Screen.Recent.route
    ),
    NavItemModel(
        defaultIcon = Icons.Outlined.Notifications,
        selectedIcon = Icons.Filled.Notifications,
        route = Screen.Notification.route
    ),
    NavItemModel(
        defaultIcon = Icons.Outlined.AccountCircle,
        selectedIcon = Icons.Filled.AccountCircle,
        route = Screen.Profile.route
    )
)