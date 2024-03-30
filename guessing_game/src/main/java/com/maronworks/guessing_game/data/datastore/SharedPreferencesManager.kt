package com.maronworks.guessing_game.data.datastore

import android.content.Context

class SharedPreferencesManager(private val context: Context) {
    private val key = "completed"
    private val sharedPreferences by lazy {
        context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    fun isFirstLaunch() :Boolean{
        val isCompleted = sharedPreferences.getBoolean(key, false)
        return !isCompleted
    }

    fun setPreference() {
        sharedPreferences.edit().putBoolean(key, true).apply()
    }
}