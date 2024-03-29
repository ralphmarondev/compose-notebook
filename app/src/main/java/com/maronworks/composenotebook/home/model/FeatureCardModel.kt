package com.maronworks.composenotebook.home.model

import androidx.annotation.DrawableRes

data class FeatureCardModel(
    val onClick: () -> Unit,
    @DrawableRes val image: Int,
    val title: String,
    val subTitle: String
)
