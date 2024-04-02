package com.maronworks.composenotebook.features.instagram_mini.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maronworks.composenotebook.R
import com.maronworks.composenotebook.features.instagram_mini.presentation.home.components.HorizontalRowStories
import com.maronworks.composenotebook.features.instagram_mini.presentation.home.components.PostCard
import com.maronworks.composenotebook.features.instagram_mini.presentation.home.model.PostModel
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

@Preview
@Composable
private fun HomeScreenPrev() {
    ComposeNotebookTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onExit: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Instagram Mini",
                        fontFamily = FontFamily.Monospace
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onExit) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBackIosNew,
                            contentDescription = ""
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.AddBox,
                            contentDescription = ""
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.Mail,
                            contentDescription = ""
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item {
                HorizontalRowStories()
            }
            item {
                Divider(modifier = Modifier.padding(5.dp))

                val posts = listOf(
                    PostModel(
                        image = R.drawable.sample_image,
                        username = "cute_pic",
                        posts = listOf(
                            R.drawable.sample_image
                        ),
                        description = "Just One Image",
                        dateAndTime = "2024-04-01 * 5:37PM * from Earth"
                    ),
                    PostModel(
                        image = R.drawable.sample_image,
                        username = "cute_pic",
                        posts = listOf(
                            R.drawable.sample_image,
                            R.drawable.sample_image,
                        ),
                        description = "Simple Image",
                        dateAndTime = "2024-04-01 * 5:37PM * from Earth"
                    ),
                    PostModel(
                        image = R.drawable.sample_image,
                        username = "cute_pic",
                        posts = listOf(
                            R.drawable.sample_image,
                            R.drawable.sample_image,
                            R.drawable.sample_image,
                        ),
                        description = "Second Image",
                        dateAndTime = "2025-04-01 * 5:37PM * from Earth"
                    ),
                )

                posts.forEachIndexed { _, item ->
                    PostCard(
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 10.dp),
                        image = item.image,
                        username = item.username,
                        posts = item.posts,
                        description = item.description,
                        dateAndTime = item.dateAndTime
                    )
                }
            }
            item {
                // padding at the bottom
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}