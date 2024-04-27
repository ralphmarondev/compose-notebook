package com.maronworks.composenotebook.home.features.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuOpen
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maronworks.composenotebook.R
import com.maronworks.composenotebook.home.features.home.components.DrawerContent
import com.maronworks.composenotebook.home.features.home.components.FeatureAndSearchCard
import com.maronworks.composenotebook.home.features.home.components.ItemContainer
import com.maronworks.composenotebook.home.features.home.model.apps.AppModel
import com.maronworks.composenotebook.mini_apps.converter.ConverterActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(
    scope: CoroutineScope = rememberCoroutineScope(),
    context: Context = LocalContext.current,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            DrawerContent(
                scope = scope,
                drawerState = drawerState
            )
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { /*TODO*/ },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Outlined.MenuOpen,
                                contentDescription = ""
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                FeatureAndSearchCard()

                Text(
                    text = "Popular Apps",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                ) {
                    val listOfApps = listOf(
                        AppModel(
                            image = R.drawable.compose_img,
                            label = "Compose Basics",
                            onClick = {}
                        ),
                        AppModel(
                            image = R.drawable.kotlin_img,
                            label = "Converter",
                            onClick = {
                                val intent = Intent(context, ConverterActivity::class.java)
                                context.startActivity(intent)
                            }
                        ),
                        AppModel(
                            image = R.drawable.kotlin_img,
                            label = "Hello World",
                            onClick = {}
                        ),
                        AppModel(
                            image = R.drawable.compose_img,
                            label = "Hello World",
                            onClick = {}
                        ),
                    )

                    items(listOfApps.size) { index ->
                        ItemContainer(
                            AppModel(
                                image = listOfApps[index].image,
                                label = listOfApps[index].label,
                                onClick = listOfApps[index].onClick
                            )
                        )
                    }
                }
            }
        }
    }
}