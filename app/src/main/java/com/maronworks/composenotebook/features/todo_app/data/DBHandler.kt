package com.maronworks.composenotebook.features.todo_app.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.maronworks.composenotebook.features.todo_app.model.notes.NoteModel

class DBHandler(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        private const val DB_NAME = "app_db"
        private const val DB_VERSION = 1

        const val NOTES_TABLE = "notes_table"
        private const val NOTES_ID = "notes_id"
        private const val NOTES_TITLE = "notes_title"
        private const val NOTES_CONTENT = "notes_content"
        private const val DATE_ADDED = "date_added"
        private const val CREATE_NOTES_TABLE_QUERY =
            "CREATE TABLE $NOTES_TABLE (" +
                    "$NOTES_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$NOTES_TITLE TEXT NOT NULL, " +
                    "$NOTES_CONTENT TEXT NOT NULL, " +
                    "$DATE_ADDED TEXT NOT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_NOTES_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $NOTES_TABLE")
    }

    fun addNotes(note: NoteModel) {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(NOTES_TITLE, note.title)
        values.put(NOTES_CONTENT, note.content)
        values.put(DATE_ADDED, note.dateAdded)

        db.insert(NOTES_TABLE, null, values)
    }

    fun readNotes() {
        // TODO: Implement this
    }

    fun updateNotes() {
        // TODO: Implement this
    }

    fun deleteNotes() {
        // TODO: Implement this
    }
}