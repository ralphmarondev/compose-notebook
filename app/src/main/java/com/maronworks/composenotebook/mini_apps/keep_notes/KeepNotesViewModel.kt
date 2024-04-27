package com.maronworks.composenotebook.mini_apps.keep_notes

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.maronworks.composenotebook.mini_apps.keep_notes.core.local.data.DBHandler
import com.maronworks.composenotebook.mini_apps.keep_notes.core.model.note.NoteModel
import com.maronworks.composenotebook.mini_apps.keep_notes.core.util.getCurrentDate

@SuppressLint("StaticFieldLeak")
class KeepNotesViewModel(private val context: Context) : ViewModel() {
    var notes = mutableListOf<NoteModel>()

    fun saveNote(
        title: String,
        content: String,
    ): Boolean {
        Log.d("keep_notes_db", "Title: $title, content: $content")

        val db = DBHandler(context)

        try {
            db.addNotes(
                NoteModel(
                    title = title,
                    content = content,
                    dateAdded = getCurrentDate()
                )
            )
            Log.d("keep_notes_db", "Note saved successfully")
            return true
        } catch (ex: Exception) {
            Log.d("keep_notes_db", "Error: ${ex.message}")
        }
        return false
    }

    fun getAllNotes() {
        val db = DBHandler(context)

        try {
            notes.clear()
            notes.addAll(db.readNotes())
            notes.reverse()
        } catch (ex: Exception) {
            Log.d("keep_notes_db", "Error: ${ex.message}")
        }
    }
}