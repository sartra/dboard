package com.example.android.dboard.model

data class DboardModel(
    val keys: List<List<Key>>,
)

sealed class Key {
    data class Action(val type: ActionType, val onClick: (ActionType) -> Unit) : Key()
    data class Character(val value: String, val onClick: (String) -> Unit) : Key()
}

sealed class ActionType {
    object Backspace : ActionType()
    object Mic : ActionType()
    object Delete : ActionType()
    object Spacebar: ActionType()
}
