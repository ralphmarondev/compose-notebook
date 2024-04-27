package com.maronworks.composenotebook.mini_apps.keep_notes.core.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun getCurrentDate(): String {
    val currentDate = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' h:mma", Locale.ENGLISH)

    return currentDate.format(formatter).toString()
}