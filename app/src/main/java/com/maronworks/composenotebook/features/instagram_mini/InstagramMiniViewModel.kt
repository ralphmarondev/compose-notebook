package com.maronworks.composenotebook.features.instagram_mini

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class InstagramMiniViewModel: ViewModel() {
    private var selectedIndex = mutableIntStateOf(0)

    fun isSelected(value: Int):Boolean{
        return selectedIndex.intValue == value
    }

    fun setSelectedIndex(value: Int) {
        selectedIndex.intValue = value
    }
}