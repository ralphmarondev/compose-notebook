package com.maronworks.composenotebook.features.message_generator

import androidx.compose.runtime.Composable
import com.maronworks.composenotebook.features.message_generator.presentation.home.HomeScreen

val messageGeneratorVM = MessageGeneratorViewModel()
@Composable
fun MessageGenerator(
    onExit: () -> Unit
) {
    HomeScreen(
        onExit = onExit
    )
}