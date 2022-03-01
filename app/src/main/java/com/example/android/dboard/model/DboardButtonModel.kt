package com.example.android.dboard.model

import android.media.Image
import com.example.android.dboard.ui.DboardButtonType

data class DboardButtonModel(
    val type: DboardButtonType,
    val char: Char? = null,
    val icon: Image? = null,
    val callback: (() -> Unit),
    val hasFocus: Boolean,
    val description: String  = ""
)
