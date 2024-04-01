package com.maronworks.composenotebook.core.data.datastore

import android.content.Context

class AppPreference(private val context: Context) {
    private val key = "my_key"

    private val sharedPreference by lazy{
        context.getSharedPreferences(key, Context.MODE_PRIVATE)
    }

    fun isFirstLaunch():Boolean{
        val completed = sharedPreference.getBoolean(key, false)

        return !completed
    }

    fun setFirstLaunch(){
        sharedPreference.edit().putBoolean(key, true).apply()
    }
}