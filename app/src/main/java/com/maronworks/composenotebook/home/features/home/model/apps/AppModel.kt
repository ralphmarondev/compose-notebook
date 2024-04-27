package com.maronworks.composenotebook.home.features.home.model.apps

import androidx.annotation.DrawableRes
import com.maronworks.composenotebook.R

data class AppModel(
    @DrawableRes val image: Int,
    val label: String,
    val onClick: () -> Unit,
)
