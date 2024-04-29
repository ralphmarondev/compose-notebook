package com.maronworks.composenotebook.mini_apps.instagram.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.maronworks.composenotebook.R
import com.maronworks.composenotebook.mini_apps.instagram.home.components.BottomSheetContent
import com.maronworks.composenotebook.mini_apps.instagram.home.components.ImageCard
import com.maronworks.composenotebook.mini_apps.instagram.home.domain.post.PostModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeActivity(
    onExitApp: () -> Unit,
) {
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Instagram",
                        fontFamily = FontFamily.Monospace
                    )
                },
                actions = {
                    val actionIcon = listOf(
                        Icons.Outlined.FavoriteBorder,
                        Icons.Outlined.MailOutline
                    )
                    repeat(actionIcon.size) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = actionIcon[it],
                                contentDescription = ""
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onExitApp) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBackIosNew,
                            contentDescription = ""
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(2) {
                val samplePost = PostModel(
                    profilePicture = R.drawable.profile1,
                    profileName = "Hello World",
                    images = listOf(
                        R.drawable.photo1,
                        R.drawable.photo2,
                        R.drawable.photo3,
                        R.drawable.photo4,
                    ),
                    description = "Sample Post",
                    datePosted = "April 29, 2024"
                )
                ImageCard(
                    modifier = Modifier
                        .padding(10.dp),
                    onMoreClick = {
                        showBottomSheet = !showBottomSheet
                    },
                    post = samplePost
                )
            }
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                }
            ) {
                BottomSheetContent()
            }
        }
    }
}