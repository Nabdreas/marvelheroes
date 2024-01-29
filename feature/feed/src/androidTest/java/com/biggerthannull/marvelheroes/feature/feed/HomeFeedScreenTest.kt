package com.biggerthannull.marvelheroes.feature.feed

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ReleasedComicBook
import com.biggerthannull.marvelheroes.feature.feed.theme.MarvelHeroesTheme
import com.biggerthannull.marvelheroes.feature.feed.ui.composables.elements.LOADING_ELEMENT_TEST_TAG
import com.biggerthannull.marvelheroes.feature.feed.ui.composables.screens.HomeFeedScreen
import com.biggerthannull.marvelheroes.feature.feed.viewmodel.state.FeedUIState
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test

class HomeFeedScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val onComicBookClicked: (String) -> Unit = mockk()

    @Test
    fun shouldRenderLoadingElement() {
        composeTestRule.setContent {
            MarvelHeroesTheme {
                HomeFeedScreen(
                    uiState = FeedUIState.Loading,
                    onComicBookClicked = onComicBookClicked
                )
            }
        }

        composeTestRule.onNodeWithTag(LOADING_ELEMENT_TEST_TAG).assertIsDisplayed()
    }

    @Test
    fun shouldInflateListOfComics() {
        composeTestRule.setContent {
            MarvelHeroesTheme {
                HomeFeedScreen(
                    uiState = FeedUIState.Success(
                        comics = listOf(
                            ReleasedComicBook(
                                id = 91992,
                                digitalId = 56203,
                                title = "Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)",
                                thumbnail = "https://i.annihil.us/u/prod/marvel/i/mg/a/10/5ff386e1a2e88.jpg"
                            )
                        )
                    ),
                    onComicBookClicked = onComicBookClicked
                )
            }
        }

        composeTestRule.onNodeWithText("Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("https://i.annihil.us/u/prod/marvel/i/mg/a/10/5ff386e1a2e88.jpg").assertIsDisplayed()
    }

    @Test
    fun shouldDisplayAnErrorMessage() {
        composeTestRule.setContent {
            MarvelHeroesTheme {
                HomeFeedScreen(
                    uiState = FeedUIState.Error(R.string.generic_error_label),
                    onComicBookClicked = onComicBookClicked
                )
            }
        }

        composeTestRule.onNodeWithText("Sorry there has been an error, Please try again later.")
            .assertIsDisplayed()

    }
}