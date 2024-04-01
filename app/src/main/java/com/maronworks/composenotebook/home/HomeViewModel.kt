package com.maronworks.composenotebook.home

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.maronworks.composenotebook.core.navigation.Screen

class HomeViewModel : ViewModel() {
    private var selectedIndex = mutableIntStateOf(0)
    var searchText = mutableStateOf("")
        private set

    fun isSelected(value: Int): Boolean {
        return selectedIndex.intValue == value
    }

    fun setSelectedIndex(value: Int) {
        selectedIndex.intValue = value
    }

    fun setSearchText(value: String) {
        searchText.value = value
    }

    fun navigateToInstagramMini(navController: NavHostController) {
        navController.navigate(Screen.InstagramMini.route)
    }
}