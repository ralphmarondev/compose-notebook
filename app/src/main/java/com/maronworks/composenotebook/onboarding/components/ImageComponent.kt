package com.maronworks.composenotebook.onboarding.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageComponent(
    @DrawableRes image: Int,
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentScale = ContentScale.Crop
    )
}