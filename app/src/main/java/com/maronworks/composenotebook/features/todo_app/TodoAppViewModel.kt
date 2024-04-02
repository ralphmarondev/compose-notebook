package com.maronworks.composenotebook.features.todo_app

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.maronworks.composenotebook.features.todo_app.data.DBHandler
import com.maronworks.composenotebook.features.todo_app.model.notes.NoteModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class TodoAppViewModel : ViewModel() {
    var noteTitle = mutableStateOf("")
    var newNote = mutableStateOf("")
    private var selectedScreen = mutableIntStateOf(0)

    fun saveNote(context: Context): String {
        Log.d("todo_app", "Saving note...\nTitle: ${noteTitle.value}\nContent: ${newNote.value}")

        return saveNotesToDatabase(context)
    }

    fun clearFields() {
        noteTitle.value = ""
        newNote.value = ""
    }

    fun getSelectedScreen(): Int {
        return selectedScreen.intValue
    }

    fun gotoNewNoteScreen() {
        selectedScreen.intValue = 1
    }

    fun resetSelectedScreen() {
        selectedScreen.intValue = 0
    }

    // crud - create, read, update, delete note
    private fun getCurrentDate(): String {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' h:mma", Locale.ENGLISH)

        return currentDateTime.format(formatter)
    }

    private fun saveNotesToDatabase(context: Context): String {
        try {
            val db = DBHandler(context)

            // TODO: Add error checks

            db.addNotes(
                note = NoteModel(
                    title = noteTitle.value,
                    content = newNote.value,
                    dateAdded = getCurrentDate()
                )
            )
            Log.d("todo_app", "Inserted successfully!")
            return "success"
        } catch (ex: Exception) {
            Log.d("todo_app", "Insertion Error: ${ex.message}")
            return "Insertion Error: ${ex.message}"
        }
    }

}