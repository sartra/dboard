package com.example.android.dboard.model

data class DboardModel(
    val language: String,
    val keys: List<Char>,
    val hasVoiceInput: Boolean = false
)
