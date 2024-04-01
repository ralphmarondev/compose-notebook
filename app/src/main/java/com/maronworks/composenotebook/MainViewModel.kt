package com.maronworks.composenotebook

import android.content.Context
import androidx.lifecycle.ViewModel
import com.maronworks.composenotebook.core.data.datastore.AppPreference
import com.maronworks.composenotebook.core.navigation.Screen

class MainViewModel : ViewModel() {

    fun getStartDestination(context: Context): String {
        val pref = AppPreference(context)

        // if it is the first launch of the application, it will show the on_boarding_screen
        // else it will go on home_screen
        return if (pref.isFirstLaunch()) {
            pref.setFirstLaunch() // it will set the datastore that we already
            // logged in, this onboarding_screen will not show again on next launch

            Screen.OnBoarding.route
        } else {
            Screen.Home.route
        }
    }
}