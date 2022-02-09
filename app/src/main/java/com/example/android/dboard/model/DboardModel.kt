package com.example.android.dboard.model

data class DboardModel(
    val language: String,
    val keys: List<Char>,
    val hasVoiceInput: Boolean = false
) {

    val sampleDboardData = DboardModel(
        language = "en",
        keys = "abcdefghijklmnopqrstuvwxyz0123456789".toList(),
        hasVoiceInput = false
    )

    fun from(sDboard: DboardModel) = DboardModel(
        language = "en",
        keys = "abcdefghijklmnopqrstuvwxyz0123456789".toList(),
        hasVoiceInput = false
    )
}
