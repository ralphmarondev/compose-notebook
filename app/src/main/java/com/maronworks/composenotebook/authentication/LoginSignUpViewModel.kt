package com.maronworks.composenotebook.authentication

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.maronworks.composenotebook.core.data.local.db.DBHandler

@SuppressLint("StaticFieldLeak")
class LoginSignUpViewModel(private val context: Context) : ViewModel() {
    /*
     *      Returns [true] if user exists in database else return [false]
     */
    fun isUserExists(
        username: String,
        password: String,
    ): Boolean {
        // check if fields [username, password] is empty
        if (username.isEmpty() || password.isEmpty()) {
            Log.d("db", "Username or Password: are empty.")
            return false
        }

        // checking if user exists in database
        try {
            val db = DBHandler(context)

            Log.d("db", "Checking if '$username', '$password' exists.")
            return if (db.isUserExists(username, password)) {
                Log.d("db", "Username: '$username', Password: '$password' EXISTS in database.")
                true
            } else {
                Log.d(
                    "db",
                    "Username: '$username', Password: '$password' DOES NOT EXISTS in database."
                )
                false
            }
        } catch (ex: Exception) {
            Log.d("db", "Error [isUserExists()]: ${ex.message}")
            return false
        }
    }

    /*
     *      Returns [true] if user is registered successfully else return [false]
     */
    fun registerUser(
        username: String,
        password: String,
    ): Boolean {
        // check if fields [username, password] is empty
        if (username.isEmpty() || password.isEmpty()) {
            Log.d("db", "Username or Password: are empty.")
            return false
        }

        // check if user already exists in database
        if (isUserExists(username, password)) {
            Log.d("db", "$username, $password already EXISTS in database")
            return false
        }

        // register user in database
        return try {
            val db = DBHandler(context)
            db.insertUser(username, password)
            Log.d("db", "$username, $password registered successfully")
            true
        } catch (ex: Exception) {
            Log.d("db", "Error [registerUser()]: ${ex.message}")
            false
        }
    }
}