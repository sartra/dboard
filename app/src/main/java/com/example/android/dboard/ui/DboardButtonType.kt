package com.example.android.dboard.ui

sealed class DboardButtonType {
    object Delete: DboardButtonType()
    object Clear: DboardButtonType()
    object Space: DboardButtonType()
    object Char: DboardButtonType()
}
