package com.example.android.dboard.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
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


private const val colSize = 6

@Composable
fun Dboard(model: DboardModel) {

    val buttonsRow =
        mutableListOf<Key>() // for CharButtons only - we can hard code action buttons since they don't change based on language

    BoxWithConstraints(
        modifier = Modifier
            .width(400.dp)
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
                        buttonsRow.forEach { key ->
                            CharButton(key as Key.Char, modifier = Modifier.weight(1F))
                        }
                    }
                    buttonsRow.clear()
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            // the remainder left in last row
            Row {
                buttonsRow.forEach { key ->
                    CharButton(key as Key.Char, modifier = Modifier.weight(1F))
                }
                ActionButton(
                    actionBtn = Key.Action(ActionType.SpaceBar, false, {}),
                    modifier = Modifier.weight(colSize - buttonsRow.size.toFloat())
                )
            }

            Row {
                ActionButton(
                    actionBtn = Key.Action(ActionType.Backspace, false, {}),
                    modifier = Modifier.weight(1F).padding(top = 8.dp)
                )
                ActionButton(
                    actionBtn = Key.Action(ActionType.Delete, false, {}),
                    modifier = Modifier.weight(1F).padding(top = 8.dp)
                )
            }
        }
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
