package com.example.android.dboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.android.dboard.molecules.SearchInput
import com.example.android.dboard.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenResumed {
            setContent {
                DPlusTheme(
                    content = {
//                        Dboard(
//                            DboardModel(
//                                language = "en",
//                                keys = "abcdefghijklmnopqrstuvwxyz1234567890".toList(),
//                                hasVoiceInput = false,
//                                columns = 6
//                            )
//                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DPlusTheme {
        SearchInput(t = "Search")
    }
}
