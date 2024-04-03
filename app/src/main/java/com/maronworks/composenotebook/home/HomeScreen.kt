package com.maronworks.composenotebook.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuOpen
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.Preview
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.maronworks.composenotebook.R
import com.maronworks.composenotebook.home.components.DrawerContent
import com.maronworks.composenotebook.home.components.FeatureCard2
import com.maronworks.composenotebook.home.components.TopAboutCard
import com.maronworks.composenotebook.home.model.FeatureCardModel
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme
import kotlinx.coroutines.launch

val homeViewModel = HomeViewModel()

@Preview
@Composable
private fun Default() {
    ComposeNotebookTheme {
        HomeScreen(rememberNavController())
    }
}

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val features = listOf(
        FeatureCardModel(
            onClick = {
                homeViewModel.navigateToInstagramMini(navController)
            },
            image = R.drawable.sample_image,
            title = "Instagram Mini",
            subTitle = "Version 1.0"
        ),
        FeatureCardModel(
            onClick = { homeViewModel.navigateToTodoApp(navController) },
            image = R.drawable.sample_image,
            title = "Todo App",
            subTitle = "Version 2024.04"
        ),
        FeatureCardModel(
            onClick = { homeViewModel.navigateToMessageGenerator(navController) },
            image = R.drawable.sample_image,
            title = "Message Generator",
            subTitle = "Version 2024.04"
        ),
        FeatureCardModel(
            onClick = {},
            image = R.drawable.sample_image,
            title = "Title 4",
            subTitle = "Sub title 4"
        )
    )

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            DrawerContent(
                onCloseDrawer = {
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }
                }
            )
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                HomeScreenTopBar(
                    onMenuOpen = {
                        scope.launch {
                            drawerState.apply { open() }
                        }
                    }
                )
            },
            bottomBar = {
                HomeScreenBottomBar()
            },
            containerColor = Color(0xfff0f0f0)
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                // FIXME: Make the top-about-card scroll up too when we scroll the vertical grid
                TopAboutCard()

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(features.size) {
                        FeatureCard2(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentHeight()
                                .padding(10.dp),
                            onClick = features[it].onClick,
                            image = features[it].image,
                            title = features[it].title,
                            subTitle = features[it].subTitle
                        )
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
private fun HomeScreenTopBar(
    onMenuOpen: () -> Unit
) {
    TopAppBar(
        title = { },
        navigationIcon = {
            IconButton(onClick = onMenuOpen) {
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