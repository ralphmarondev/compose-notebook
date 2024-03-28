package com.maronworks.composenotebook.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.maronworks.composenotebook.R
import com.maronworks.composenotebook.home.components.FeatureCard
import com.maronworks.composenotebook.home.model.FeatureCardModel
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val featureItems = listOf(
        FeatureCardModel(
            image = R.drawable.sample_image,
            title = "Sample Login",
            subTitle = "Check it out!",
            onClick = {
                navController.navigate(Screen.SampleLogin.route)
            }
        ),
        FeatureCardModel(
            image = R.drawable.sample_image,
            title = "Cards",
            subTitle = "3 Cards",
            onClick = { navController.navigate(Screen.CardScreen.route) }
        ),
        FeatureCardModel(
            image = R.drawable.sample_image,
            title = "Programming",
            subTitle = "Is fun",
            onClick = {}
        ),
        FeatureCardModel(
            image = R.drawable.sample_image,
            title = "Programming",
            subTitle = "Is fun",
            onClick = {}
        ),
        FeatureCardModel(
            image = R.drawable.sample_image,
            title = "Programming",
            subTitle = "Is fun",
            onClick = {}
        ),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.Menu,
                            contentDescription = ""
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(innerPadding),
            columns = GridCells.Fixed(2)
        ) {
            items(featureItems.size) {
                FeatureCard(
                    modifier = Modifier
                        .padding(10.dp),
                    image = featureItems[it].image,
                    title = featureItems[it].title,
                    subTitle = featureItems[it].subTitle,
                    onClick = featureItems[it].onClick
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Default() {
    ComposeNotebookTheme {
//        HomeScreen()
    }
}