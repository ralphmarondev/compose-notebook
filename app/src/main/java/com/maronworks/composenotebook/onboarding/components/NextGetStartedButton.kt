package com.maronworks.composenotebook.onboarding.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NextGetStartedButton(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onClick: () -> Unit,
) {
    val text = if (pagerState.currentPage < pagerState.pageCount - 1) "NEXT" else "GET STARTED"

    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = text,
        )
    }
}