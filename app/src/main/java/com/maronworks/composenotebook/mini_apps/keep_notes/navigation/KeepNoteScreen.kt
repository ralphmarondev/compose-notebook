package com.maronworks.composenotebook.mini_apps.keep_notes.navigation

sealed class KeepNoteScreen(val route: String) {
    data object Home : KeepNoteScreen("home")
    data object NewNote : KeepNoteScreen("new_note")
}