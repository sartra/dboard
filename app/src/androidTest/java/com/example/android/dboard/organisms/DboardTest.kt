package com.example.android.dboard.organisms

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.dboard.model.DboardModel
import com.example.android.dboard.ui.DboardButtonType
import com.example.android.dboard.ui.theme.AppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DboardTest {

    var txt: String? = ""
    var dBoardButtonType: DboardButtonType = DboardButtonType.Char
    var inputTextView = mutableStateOf("")

    private var model = DboardModel(
        language = "en",
        keys = "abcdefghijklmnopqrstuvwxyz1234567890".toList(),
        hasVoiceInput = false
    )

    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to an activity

    @Test
    fun testSearchInput() {

        with(composeTestRule) {

            setContent {
                AppTheme {
                    Dboard(model)
                }
            }

            onNodeWithContentDescription("dBoard_search_input").assertIsDisplayed()

//            // type letters "abc"
            onNodeWithContentDescription("dBoard_btn_0").performClick() // a
            onNodeWithContentDescription("dBoard_btn_1").performClick() // b
            onNodeWithContentDescription("dBoard_btn_2").performClick()  // c
//            // searchInput should have "abc" displayed
            onNodeWithContentDescription("dBoard_search_input").assertTextContains("abc")

            // clear all, space & backspace
            onNodeWithContentDescription("dBoard_btn_delete").performClick() // clear text field
            onNodeWithContentDescription("dBoard_btn_0").performClick() // a
            onNodeWithContentDescription("dBoard_btn_1").performClick() // b
            onNodeWithContentDescription("dBoard_btn_space").performClick() // space
            onNodeWithContentDescription("dBoard_btn_0").performClick() // a
            onNodeWithContentDescription("dBoard_btn_1").performClick() // b
            onNodeWithContentDescription("dBoard_btn_backspace").performClick() // backspace
            onNodeWithContentDescription("dBoard_search_input").assertTextContains("ab a")
        }
    }
}
