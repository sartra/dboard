package com.example.android.dboard.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.dboard.R
import com.example.android.dboard.model.ActionType
import com.example.android.dboard.model.DboardModel
import com.example.android.dboard.model.Key
import com.example.android.dboard.molecules.ActionButton
import com.example.android.dboard.molecules.CharButton
import com.example.android.dboard.molecules.DboardButton
import com.example.android.dboard.ui.DboardButtonType
import com.example.android.dboard.ui.theme.DPlusTheme


private const val colSize = 6

@Composable
fun Dboard(model: DboardModel) {

    val input = remember { mutableStateOf("") }
    val buttonsRow = mutableListOf<Key>() // CharButton or ActionButton

    val predicate: (key: Key) -> Boolean = { key ->
        when (key) {
            is Key.Char -> true
            is Key.Action -> false
        }
    }
    // returns how many char keys are in the row - to determine space width
    val charButtonsInRow = model.keys.count(predicate)
    val spaceWeight = (colSize - charButtonsInRow).toFloat()

    val isKeySpace: (type: ActionType) -> Boolean = { type ->
        when (type) {
            is ActionType.SpaceBar -> true
            else -> false
        }
    }
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface),
        contentAlignment = Alignment.TopStart
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color = MaterialTheme.colors.surface)
        ) {
            for ((keyIndex, key) in model.keys.withIndex()) {
                buttonsRow.add(key)  // creates the Char or Action button then adds it to buttonsRow

                if ((keyIndex + 1) % 6 == 0 && keyIndex > 0) {

                    Row {
                        buttonsRow.forEach {
                            KeyRouter(it, modifier = Modifier.weight(1F))
                        }
                    }
                    buttonsRow.clear()
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            // the remainder left in last row
            Row {
                buttonsRow.forEach { key ->
                    KeyRouter(key,  modifier = Modifier
                            .weight(1F))
                }
                KeyRouter(key = Key.Action(ActionType.SpaceBar, 2F,false, {}), modifier = Modifier.weight(colSize - buttonsRow.size.toFloat()))
            }
        }
    }
}

@Composable
fun KeyRouter(key: Key, modifier: Modifier) {
    when (key) {
        is Key.Char -> CharButton(key, modifier)
        is Key.Action -> ActionButton(key, modifier)
    }
}

@Composable
fun actionTypeIconRouter(actionType: ActionType): Painter {
    return when (actionType) {
        is ActionType.Backspace -> R.drawable.ic_backspace
        is ActionType.Delete -> R.drawable.ic_delete
        is ActionType.SpaceBar -> R.drawable.ic_spacebar
    }.run {
        painterResource(this)
    }
}
//
//@Composable
//fun handleButtonClick(
//    actionType: ActionType
//) {
//    actionType.let { type ->
//        when (type) {
//            BackSpace -> inputTextView.value = inputTextView.value.dropLast(1)
//            Delete -> inputTextView.value = ""
//            Space -> inputTextView.value += " "
//            Char -> inputTextView.value += txt
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun DboardPreview() {
    DPlusTheme {
        Dboard(
            DboardModel(
                keys = sampleKeys
            )
        )
    }
}

const val chars = "abcdeèfghijklmnoöpqrstuvwxyz1234567890"
fun createCharKeys(chars: String): List<Key> {
    val list = mutableListOf<Key>()
    chars.forEach { char ->
        list.add(Key.Char(char.toString(), true, {}))
    }
    return list
}
val sampleKeys = createCharKeys(chars)
