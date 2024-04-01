package com.maronworks.composenotebook.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContent(
    onCloseDrawer: () -> Unit
) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(horizontal = 20.dp, vertical = 15.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "Compose NoteBook",
                fontWeight = FontWeight.W500,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Text(
                text = "Version: 2024.04.02",
                color = MaterialTheme.colorScheme.onSecondary
            )
        }

        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            NavigationDrawerItem(
                label = {
                    Text(
                        text = "About",
                        modifier = Modifier
                            .padding(horizontal = 5.dp),
                        fontFamily = FontFamily.Monospace,
                    )
                },
                selected = true,
                onClick = { /*TODO*/ },
                badge = {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = ""
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    selectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    selectedTextColor = MaterialTheme.colorScheme.onTertiaryContainer
                )
            )

            Spacer(modifier = Modifier.weight(1f))
            NavigationDrawerItem(
                label = {
                    Text(
                        text = "Close",
                        modifier = Modifier
                            .padding(horizontal = 5.dp),
                        fontFamily = FontFamily.Monospace,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                },
                selected = false,
                onClick = onCloseDrawer,
                badge = {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "",
                        tint = Color.Red
                    )
                }
            )
        }
    }
}