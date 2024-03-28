package com.maronworks.hello

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var showBottomBar = mutableStateOf(true)
        private set

    fun toggleShowBottomBar() {
        showBottomBar.value = !showBottomBar.value
    }
}