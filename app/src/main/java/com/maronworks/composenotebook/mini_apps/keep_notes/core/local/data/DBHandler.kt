package com.maronworks.composenotebook.mini_apps.keep_notes.core.local.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.maronworks.composenotebook.mini_apps.keep_notes.core.model.note.NoteModel

class DBHandler(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        private const val DB_NAME = "keep_notes_db"
        private const val DB_VERSION = 1

        const val NOTES_TABLE = "notes_table"
        private const val ID = "notes_id"
        private const val TITLE = "notes_title"
        private const val CONTENT = "notes_content"
        private const val DATE_ADDED = "date_added"
        private const val CREATE_NOTES_TABLE_QUERY =
            "CREATE TABLE $NOTES_TABLE (" +
                    "$ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$TITLE TEXT NOT NULL, " +
                    "$CONTENT TEXT, " +
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

        values.put(TITLE, note.title)
        values.put(CONTENT, note.content)
        values.put(DATE_ADDED, note.dateAdded)

        db.insert(NOTES_TABLE, null, values)
    }

    fun readNotes(): MutableList<NoteModel> {
        val items = mutableListOf<NoteModel>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $NOTES_TABLE", null)

        cursor?.let {
            if (cursor.moveToFirst()) {
                do {
                    items.add(
                        NoteModel(
                            id = cursor.getInt(0),
                            title = cursor.getString(1),
                            content = cursor.getString(2),
                            dateAdded = cursor.getString(3)
                        )
                    )
                } while (cursor.moveToNext())
            }
            cursor.close()
        }
        return items
    }
}