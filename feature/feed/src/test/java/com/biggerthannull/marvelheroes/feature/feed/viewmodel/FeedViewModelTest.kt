package com.biggerthannull.marvelheroes.feature.feed.viewmodel

import com.biggerthannull.marvelheroes.domain.comics.usecase.GetReleasedComicBooksUseCase
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicsResult
import com.biggerthannull.marvelheroes.feature.feed.ViewTestData
import com.biggerthannull.marvelheroes.feature.feed.viewmodel.state.FeedUIState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FeedViewModelTest {

    private val getReleasedComicBooksUseCase: GetReleasedComicBooksUseCase = mockk()
    private val sut by lazy { FeedViewModel(getReleasedComicBooksUseCase) }

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @AfterEach
    fun cleanup() {
        Dispatchers.resetMain()
    }

    @Test
    fun `should load list of comics`() = runTest {
        // Given
        coEvery { getReleasedComicBooksUseCase.execute() } returns ComicsResult.Success(
            data = listOf(ViewTestData.releasedComicBook)
        )

        // When
        val result = sut.uiState.value

        // Then
        assertTrue(result is FeedUIState.Success)
    }

    @Test
    fun `should throw an error state`() = runTest {
        // Given
        coEvery { getReleasedComicBooksUseCase.execute() } returns ComicsResult.Failed

        // When
        val result = sut.uiState.value

        // Then
        assertTrue(result is FeedUIState.Error)
    }
}