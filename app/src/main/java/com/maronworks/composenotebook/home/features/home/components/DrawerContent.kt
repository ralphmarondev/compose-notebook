package com.maronworks.composenotebook.home.features.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maronworks.composenotebook.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(
    scope: CoroutineScope,
    drawerState: DrawerState,
) {
    ModalDrawerSheet {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Image(
                painter = painterResource(id = R.drawable.compose_img),
                contentDescription = "",
                modifier = Modifier
                    .size(140.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(10.dp)
            ) {
                Text(
                    text = "Compose Notebook",
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp
                )
                Text(
                    text = "Version 2.0",
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp)
        ) {
            NavigationDrawerItem(
                label = {
                    Text(
                        text = "About",
                        fontWeight = FontWeight.W500
                    )
                },
                selected = true,
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 5.dp),
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    selectedContainerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = ""
                    )
                }
            )

            Spacer(modifier = Modifier.weight(1f))
            NavigationDrawerItem(
                label = {
                    Text(
                        text = "Close Drawer",
                        fontWeight = FontWeight.W500
                    )
                },
                selected = false,
                onClick = {
                    scope.launch {
                        drawerState.close()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 5.dp),
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    selectedContainerColor = MaterialTheme.colorScheme.tertiary
                ),
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = ""
                    )
                }
            )
        }
    }
}