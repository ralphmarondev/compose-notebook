package com.maronworks.composenotebook.mini_apps.instagram.home.domain.post

import androidx.annotation.DrawableRes

data class PostModel(
    @DrawableRes val profilePicture: Int,
    val profileName: String,
    @DrawableRes val images: List<Int>,
    val description: String,
    val datePosted: String,
)