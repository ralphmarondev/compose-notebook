package com.maronworks.composenotebook.home.features.home.model.apps

import androidx.annotation.DrawableRes
import com.maronworks.composenotebook.R

data class AppModel(
    @DrawableRes val image: Int,
    val label: String,
    val onClick: () -> Unit,
)

val listOfApps = listOf(
    AppModel(
        image = R.drawable.compose_img,
        label = "Compose Basics",
        onClick = {}
    ),
    AppModel(
        image = R.drawable.kotlin_img,
        label = "Hello World",
        onClick = {}
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
