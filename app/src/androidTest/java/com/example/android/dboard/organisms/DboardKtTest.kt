package com.example.android.dboard.organisms

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import com.example.android.dboard.model.DboardModel
import com.example.android.dboard.ui.theme.AppTheme
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test

class DboardKtTest : TestCase() {

    private var searchInput = ""
    private var model = DboardModel(
        language = "en",
        keys = "abcdefghijklmnopqrstuvwxyz1234567890".toList(),
        hasVoiceInput = false
    )

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSearchInput() {

        with(composeTestRule) {

            setContent {
                searchInput = "abc"
                AppTheme {
                    Dboard(model)
                }
            }

            onNodeWithContentDescription("dBoard_search_input").assertIsDisplayed()
            // type letters "abc"
            onNodeWithContentDescription("dBoard_btn_a").performClick()
            onNodeWithContentDescription("dBoard_btn_b").performClick()
            onNodeWithContentDescription("dBoard_btn_c").performClick()
            // searchInput should have "abc" displayed
            onNodeWithContentDescription("dBoard_search_input").assertTextContains(searchInput)
        }
    }

    fun testHandleButtonClick() {}
}
