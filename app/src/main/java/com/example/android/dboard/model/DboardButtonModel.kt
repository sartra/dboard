package com.example.android.dboard.model

import com.example.android.dboard.ui.DboardButtonType

data class DboardButtonModel(
    val type: DboardButtonType = DboardButtonType.Char,
    val char: Char? = null,
    val onClick: (() -> Unit)
)
