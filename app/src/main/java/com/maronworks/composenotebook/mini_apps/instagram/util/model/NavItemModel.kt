package com.maronworks.composenotebook.mini_apps.instagram.util.model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItemModel(
    val defaultIcon: ImageVector,
    val selectedIcon: ImageVector,
    val label: String,
    val onClick: () -> Unit
)