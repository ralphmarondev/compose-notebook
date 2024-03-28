package com.maronworks.hello.home.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.Modifier

data class FeatureCardModel(
    val modifier: Modifier = Modifier,
    @DrawableRes val image: Int,
    val title: String,
    val subTitle: String,
    val onClick: () -> Unit
)