package com.example.android.dboard.ui

sealed class DBoardButtonType {
    object Delete: DBoardButtonType()
    object Clear: DBoardButtonType()
    object Space: DBoardButtonType()
    object Char: DBoardButtonType()
}


//sealed class AccountTabs(val position: Int) {
//    object Account : AccountTabs(position = 0)
//    object About : AccountTabs(position = 1)
//    object Help : AccountTabs(position = 2)
//    object SignOut : AccountTabs(position = 3)
//    object Debug : AccountTabs(position = 4)
//}
