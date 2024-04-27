package com.maronworks.composenotebook.mini_apps.converter.navigation

sealed class ConverterScreen (val route: String){
    data object Home: ConverterScreen("home")
    data object Length: ConverterScreen("length")
}