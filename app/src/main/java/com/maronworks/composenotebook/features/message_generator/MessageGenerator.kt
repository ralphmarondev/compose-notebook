package com.maronworks.composenotebook.features.message_generator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.maronworks.composenotebook.features.message_generator.presentation.home.HomeScreen

val messageGeneratorVM = MessageGeneratorViewModel()
@Composable
fun MessageGenerator(
    navController: NavHostController
) {
    HomeScreen(
        onExit = {
            navController.popBackStack()
        }
    )
}