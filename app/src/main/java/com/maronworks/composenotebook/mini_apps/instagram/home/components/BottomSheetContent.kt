package com.maronworks.composenotebook.mini_apps.instagram.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.NotInterested
import androidx.compose.material.icons.outlined.Report
import androidx.compose.material.icons.outlined.RoomPreferences
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maronworks.composenotebook.mini_apps.instagram.ui.theme.InstagramTheme

@Composable
fun BottomSheetContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .border(
                    2.dp, Brush.linearGradient(
                        listOf(
                            Color.Magenta,
                            Color.Red
                        )
                    ),
                    CircleShape
                )
                .padding(5.dp)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.BookmarkBorder,
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
        Divider(modifier = Modifier.padding(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.Send,
                contentDescription = ""
            )

            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = "Were moving things around",
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp
                )
                Text(text = "See where to share and link")
            }
        }

        val items = listOf(
            Content(
                icon = Icons.Outlined.Info,
                text = "Why you're seeing this post"
            ),
            Content(
                icon = Icons.Outlined.NotInterested,
                text = "Not Interested"
            ),
            Content(
                icon = Icons.Outlined.AccountCircle,
                text = "About this account"
            ),
            Content(
                icon = Icons.Outlined.Report,
                text = "Report"
            ),
        )

        repeat(items.size) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = items[it].icon,
                    contentDescription = "",
                    modifier = Modifier
                        .size(28.dp)
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = items[it].text)
            }
        }

        Divider(modifier = Modifier.padding(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.RoomPreferences,
                contentDescription = "",
                modifier = Modifier
                    .size(28.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = "Manage content preferences")
        }

        Spacer(modifier = Modifier.height(50.dp))
    }
}

private data class Content(
    val icon: ImageVector,
    val text: String,
)

@Preview
@Composable
private fun Default() {
    InstagramTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                BottomSheetContent()
            }
        }
    }
}