package com.maronworks.composenotebook.onboarding

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maronworks.composenotebook.R
import com.maronworks.composenotebook.onboarding.components.ImageComponent
import com.maronworks.composenotebook.onboarding.components.NextGetStartedButton
import com.maronworks.composenotebook.onboarding.components.PagerIndicator
import com.maronworks.composenotebook.onboarding.components.TitleDescription
import com.maronworks.composenotebook.ui.theme.ComposeNotebookTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Preview
@Composable
private fun Default() {
    ComposeNotebookTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            OnBoardingActivity(
                onGetStarted = {

                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingActivity(
    scope: CoroutineScope = rememberCoroutineScope(),
    onGetStarted: () -> Unit,
) {
    val pagerState = rememberPagerState {
        3
    }
    val listOfImage = listOf(
        R.drawable.compose_img,
        R.drawable.kotlin_img,
        R.drawable.cute_me
    )
    val listOfTitle = listOf(
        "COMPOSE NOTEBOOK",
        "COMPOSE NOTEBOOK",
        "COMPOSE NOTEBOOK",
    )
    val listOfDescription = listOf(
        "Compose Notebook. Implementation of different compose components",
        "It is written on Kotlin programming language",
        "Developed by: Ralph Maron Eda"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
            ) { index ->
                ImageComponent(image = listOfImage[index])
            }
            Spacer(modifier = Modifier.height(30.dp))

            TitleDescription(
                modifier = Modifier
                    .padding(10.dp),
                title = listOfTitle[pagerState.currentPage],
                description = listOfDescription[pagerState.currentPage]
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PagerIndicator(pagerState = pagerState)
                NextGetStartedButton(
                    pagerState = pagerState,
                    onClick = {
                        if (pagerState.currentPage < pagerState.pageCount - 1) {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                            Log.d("on_boarding", "Current Page: ${pagerState.currentPage}")
                        } else {
                            onGetStarted()
                            Log.d("on_boarding", "Navigate Login Screen")
                        }
                    }
                )
            }
        }
    }
}