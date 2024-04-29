package com.maronworks.composenotebook.core.util.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.maronworks.composenotebook.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    afterSplash: () -> Unit,
) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 3000,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }
            )
        )
        // delay time
        delay(1500L)
        afterSplash()
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.compose_img),
            contentDescription = "",
            modifier = Modifier
                .size(250.dp)
                .scale(scale.value),
            contentScale = ContentScale.Crop
        )
    }
}