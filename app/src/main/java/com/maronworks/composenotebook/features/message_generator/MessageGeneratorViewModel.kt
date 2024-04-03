package com.maronworks.composenotebook.features.message_generator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MessageGeneratorViewModel : ViewModel() {
    var randomMessage = mutableStateOf("Some random message")

    fun onGenerateClick() {
        randomMessage.value = getRandomMessage()
    }

    private fun getRandomMessage(): String {
        val randomMessages = listOf("hello", "hi")

        return randomMessages[Random.nextInt(randomMessages.size)]
    }
}