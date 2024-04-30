package com.maronworks.composenotebook.home.features.profile.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Notes
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class CardButtonModel(
    val icon: ImageVector,
    val text: String
)

val listOfCardButton = listOf(
    CardButtonModel(
        icon = Icons.Outlined.Settings,
        text = "My Reviews"
    ),
    CardButtonModel(
        icon = Icons.Outlined.Notes,
        text = "Account Settings"
    ),
    CardButtonModel(
        icon = Icons.Outlined.AccountCircle,
        text = "Personal Information"
    ),
    CardButtonModel(
        icon = Icons.Outlined.Notifications,
        text = "Notification"
    ),

)
