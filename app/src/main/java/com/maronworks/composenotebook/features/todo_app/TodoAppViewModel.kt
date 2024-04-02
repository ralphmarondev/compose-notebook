package com.maronworks.composenotebook.features.todo_app

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TodoAppViewModel : ViewModel() {
    var newNote = mutableStateOf("")

    fun saveNote() {
        Log.d("todo_app", "Saving note...\nContents: ${newNote.value}")
    }
}