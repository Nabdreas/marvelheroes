package com.biggerthannull.marvelheroes.feature.feed.viewmodel

import com.biggerthannull.marvelheroes.domain.comics.usecase.GetReleasedComicBooksUseCase
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicsResult
import com.biggerthannull.marvelheroes.feature.feed.ViewTestData
import com.biggerthannull.marvelheroes.feature.feed.viewmodel.state.FeedUIState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
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
    fun `verify that initial state is Loading`() = runTest {
        // Given
        coEvery { getReleasedComicBooksUseCase.execute() } returns ComicsResult.Success(
            data = listOf(ViewTestData.releasedComicBook)
        )

        // When
        val result = sut.uiState.first()

        // Then
        assertTrue(result is FeedUIState.Loading)
    }
}