package com.example.android.dboard.organisms

import android.util.Log
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
import com.example.android.dboard.ui.theme.DPlusTheme

@Composable
fun Dboard(model: DboardModel) {

    val input = remember { mutableStateOf("") }
    val buttonsRow = mutableListOf<Key>() // CharButton or ActionButton

    val colSize = 6
    val predicate: (key: Key) -> Boolean = { key ->
        when (key) {
            is Key.Char -> true
            is Key.Action -> false
        }
    }
    // returns how many char keys are in the row - to determine space width
    val charButtonsInRow = model.keys.count(predicate)
    val spaceWeight = (colSize - charButtonsInRow).toFloat()

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

                    Row(modifier = Modifier
                        .fillMaxWidth(1F)
                    ) {
                        buttonsRow.forEach {
                            KeyRouter(it)
                        }
                    }
                    Log.d("dboard", "~~~buttonsRow: $buttonsRow\n")
                    buttonsRow.clear()
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            // the remainder left in last row
            Row(modifier = Modifier.fillMaxWidth(1F)) {
                buttonsRow.forEach {
                    KeyRouter(it)
                }
            }
        }
    }
}

@Composable
fun KeyRouter(key: Key) {
    when (key) {
        is Key.Char -> CharButton(key)
        is Key.Action -> ActionButton(key)
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

val sampleKeys = listOf(
    Key.Char("a", true, {}),
    Key.Char("b", false, {}),
    Key.Char("c", false, {}),
    Key.Char("d", false, {}),
    Key.Char("e", false, {}),
    Key.Char("è", false, {}),
    Key.Char("f", false, {}),
    Key.Char("g", false, {}),
    Key.Char("h", false, {}),
    Key.Char("i", false, {}),
    Key.Char("j", false, {}),
    Key.Char("k", false, {}),
    Key.Char("l", false, {}),
    Key.Char("m", false, {}),
    Key.Char("n", false, {}),
    Key.Char("o", false, {}),
    Key.Char("ö", false, {}),
    Key.Char("p", false, {}),
    Key.Char("q", false, {}),
    Key.Char("r", false, {}),
    Key.Char("s", false, {}),
    Key.Char("t", false, {}),
    Key.Char("u", false, {}),
    Key.Char("v", false, {}),
    Key.Char("w", false, {}),
    Key.Char("x", false, {}),
    Key.Char("y", false, {}),
    Key.Char("z", false, {}),
    Key.Char("1", false, {}),
    Key.Char("2", false, {}),
    Key.Char("3", false, {}),
    Key.Char("4", false, {}),
    Key.Char("5", false, {}),
    Key.Char("6", false, {}),
    Key.Char("7", false, {}),
    Key.Char("8", false, {}),
    Key.Char("9", false, {}),
    Key.Char("0", false, {}),
    Key.Action(ActionType.SpaceBar, false, {}),
    Key.Action(ActionType.Delete, false, {}),
    Key.Action(ActionType.Backspace, false, {})
)
