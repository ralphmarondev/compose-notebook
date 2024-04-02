package com.maronworks.composenotebook.features.todo_app

import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TodoAppViewModel : ViewModel() {
    var noteTitle = mutableStateOf("")
    var newNote = mutableStateOf("")
    private var selectedScreen = mutableIntStateOf(0)

    fun saveNote() {
        Log.d("todo_app", "Saving note...\nTitle: ${noteTitle.value}\nContent: ${newNote.value}")
    }

    fun getSelectedScreen(): Int{
        return selectedScreen.intValue
    }

    fun gotoNewNoteScreen() {
        selectedScreen.intValue = 1
    }

    fun resetSelectedScreen() {
        selectedScreen.intValue = 0
    }
}