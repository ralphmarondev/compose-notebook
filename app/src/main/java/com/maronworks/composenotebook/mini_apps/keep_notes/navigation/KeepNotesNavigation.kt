package com.maronworks.composenotebook.mini_apps.keep_notes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maronworks.composenotebook.mini_apps.keep_notes.KeepNotesViewModel
import com.maronworks.composenotebook.mini_apps.keep_notes.home.KeepNoteHomeScreen
import com.maronworks.composenotebook.mini_apps.keep_notes.new_note.NewNoteScreen

@Composable
fun KeepNotesNavigation(
    navController: NavHostController = rememberNavController(),
    viewModel: KeepNotesViewModel,
    exitApp: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = KeepNoteScreen.Home.route
    ) {
        composable(KeepNoteScreen.Home.route) {
            viewModel.getAllNotes()
            KeepNoteHomeScreen(
                viewModel = viewModel,
                exitApp = exitApp,
                addNewNote = {
                    navController.navigate(KeepNoteScreen.NewNote.route)
                }
            )
        }
        composable(KeepNoteScreen.NewNote.route) {
            NewNoteScreen(
                viewModel = viewModel,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}