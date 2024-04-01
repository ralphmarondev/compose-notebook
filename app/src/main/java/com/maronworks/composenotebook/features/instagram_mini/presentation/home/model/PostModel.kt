package com.maronworks.composenotebook.features.instagram_mini.presentation.home.model

import androidx.annotation.DrawableRes

data class PostModel(
    @DrawableRes val image: Int,
    val username: String,
    @DrawableRes val posts: List<Int>,
    val description: String,
    val dateAndTime: String
)