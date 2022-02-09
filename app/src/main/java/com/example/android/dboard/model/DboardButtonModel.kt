package com.example.android.dboard.model

import com.example.android.dboard.ui.DboardButtonType

data class DboardButtonModel(
    val type: DboardButtonType = DboardButtonType.Char,
    val char: Char? = null,
    val callback: (t: String, type: DboardButtonType) -> Any
){
    val dBoardDelete = DboardButtonModel(
        type  = DboardButtonType.Delete,
        callback = callback
    )
    val dBoardClear = DboardButtonModel(
        type  = DboardButtonType.Clear,
        callback = callback
    )
    val dBoardSpace = DboardButtonModel(
        type  = DboardButtonType.Space,
        callback = callback
    )
}
