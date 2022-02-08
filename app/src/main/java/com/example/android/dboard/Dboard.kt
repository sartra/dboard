package com.example.android.dboard

import android.util.DisplayMetrics
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.dboard.ui.theme.DPlusTheme
import kotlinx.coroutines.launch

@Composable
fun Dboard() {
    val input = remember { mutableStateOf("") }
    val state = rememberScrollState()
    val scope = rememberCoroutineScope()
//    val buttonType = DBoardButtonType.CHAR
    val callback = { text: String ->
//        handleButtonClick(text, buttonType, input)
        handleButtonClick(text, input)
        scope.launch { state.animateScrollTo(state.maxValue) }
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        contentAlignment = Alignment.TopStart
    ) {
        val width = 600.dp
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.surface)
        ) {
            Column(
                modifier = Modifier
                    .width(width)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(1.0F)
                ) {
                    SearchInput(input.value)
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .width(300.dp)
                        .background(color = MaterialTheme.colors.primarySurface)
                        .padding(16.dp)
                ) {
                    DboardRow(
                        listOf("a", "b", "c", "d", "e", "f"),
                        listOf(0.25f, 0.25f, 0.25f, 0.25f, 0.25f, 0.25f),
                        callback
                    )
                    DboardRow(
                        listOf("h", "i", "j", "k", "l", "m"),
                        listOf(0.25f, 0.25f, 0.25f, 0.25f, 0.25f, 0.25f),
                        callback
                    )
                    DboardRow(
                        listOf("n", "o", "p", "q", "r", "s"),
                        listOf(0.25f, 0.25f, 0.25f, 0.25f, 0.25f, 0.25f),
                        callback
                    )
                    DboardRow(
                        listOf("t", "u", "v", "w", "x", "y"),
                        listOf(0.25f, 0.25f, 0.25f, 0.25f, 0.25f, 0.25f),
                        callback
                    )
                    DboardRow(
                        listOf("z", "0", "1", "2", "3", "4"),
                        listOf(0.25f, 0.25f, 0.25f, 0.25f, 0.25f, 0.25f),
                        callback
                    )
                    DboardRow(
                        listOf("5", "6", "7", "8", "9", "--"),
                        listOf(0.25f, 0.25f, 0.25f, 0.25f, 0.25f, 0.25f),
                        callback
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DboardPreview() {
//    DPlusTheme {
//        Dboard()
//    }
//}
