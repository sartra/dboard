package com.example.android.dboard.model

data class DboardModel(
    val keys: List<Key>,
)

sealed class Key {
    data class Action(
        val type: ActionType,
        val weight: Float,
        val hasFocus: Boolean,
        val onClick: (ActionType) -> Unit) : Key()

    data class Char(
        val value: String,
        val hasFocus: Boolean,
        val onClick: (String) -> Unit) : Key()
}

sealed class ActionType {
    object Backspace : ActionType()
    object Delete : ActionType()
    object SpaceBar : ActionType()
}
