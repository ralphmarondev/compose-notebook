package com.maronworks.composenotebook.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuOpen
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.Preview
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maronworks.composenotebook.R
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

val homeViewModel = HomeViewModel()

@Preview
@Composable
private fun Default() {
    ComposeNotebookTheme {
        HomeScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HomeScreenTopBar()
        },
        bottomBar = {
            HomeScreenBottomBar()
        },
        containerColor = Color(0xfff0f0f0)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(205.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(vertical = 10.dp, horizontal = 20.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Compose NoteBook",
                                fontWeight = FontWeight.W500
                            )
                            Text(text = "Version: 2024.03.28")
                            Spacer(
                                modifier = Modifier
                                    .padding(bottom = 20.dp)
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .align(Alignment.BottomCenter)
                            .background(Color.Transparent)
                    ) {
                        OutlinedTextField(
                            value = homeViewModel.searchText.value,
                            onValueChange = { value ->
                                homeViewModel.setSearchText(value)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 25.dp),
                            placeholder = {
                                Text(text = "Search...")
                            },
                            colors = TextFieldDefaults.colors(
                                disabledContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                focusedContainerColor = Color.White
                            ),
                            maxLines = 1
                        )
                    }
                }
            }

            items(2) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
                ) {
                    repeat(2) {
                        ElevatedCard(
                            onClick = {},
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentHeight()
                                .padding(10.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.sample_image),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(75.dp)
                                        .clip(RoundedCornerShape(8.dp)),
                                    contentScale = ContentScale.Crop
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Hello There whatever.",
                                    fontSize = 14.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "Sub title.",
                                    fontSize = 12.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun HomeScreenBottomBar() {
    val bottomItems = listOf(
        Icons.Outlined.Home,
        Icons.Outlined.Preview,
        Icons.Outlined.NotificationsNone,
        Icons.Outlined.AccountCircle
    )

    NavigationBar {
        bottomItems.forEachIndexed { index, imageVector ->
            NavigationBarItem(
                selected = homeViewModel.isSelected(index),
                onClick = { homeViewModel.setSelectedIndex(index) },
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreenTopBar() {
    TopAppBar(
        title = { },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.MenuOpen,
                    contentDescription = ""
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xfff0f0f0),
            navigationIconContentColor = MaterialTheme.colorScheme.primary
        )
    )
}