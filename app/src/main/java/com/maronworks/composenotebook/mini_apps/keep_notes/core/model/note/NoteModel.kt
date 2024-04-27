package com.maronworks.composenotebook.mini_apps.keep_notes.core.model.note

data class NoteModel(
    val id: Int = -1,
    val title: String,
    val content: String,
    val dateAdded: String,
)