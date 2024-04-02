package com.maronworks.composenotebook.features.todo_app.model.notes

data class NoteModel(
    val id: Int = -1,
    val title: String,
    val content: String,
    val dateAdded: String
)