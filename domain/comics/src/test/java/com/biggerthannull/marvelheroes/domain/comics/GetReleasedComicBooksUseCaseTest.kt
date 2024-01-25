package com.biggerthannull.marvelheroes.domain.comics

import com.biggerthannull.marvelheroes.domain.comics.repository.ComicsRepository
import com.biggerthannull.marvelheroes.domain.comics.usecase.GetReleasedComicBooksUseCase
import com.biggerthannull.marvelheroes.domain.comics.usecase.GetReleasedComicBooksUseCaseImpl
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicsResult
import com.biggerthannull.marvelheroes.domain.comics.utils.DomainTestData.releasedComicBook
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GetReleasedComicBooksUseCaseTest {
    private val repo: ComicsRepository = mockk()
    private val sut: GetReleasedComicBooksUseCase = GetReleasedComicBooksUseCaseImpl(repo)

    @Test
    fun `returns comic books successfully`() = runTest {
        // Given
        coEvery { repo.getComics() } returns ComicsResult.Success(listOf(releasedComicBook))

        // When
        val result = sut.execute()

        // Then
        assertTrue(result is ComicsResult.Success)
        assertEquals(listOf(releasedComicBook), (result as ComicsResult.Success).data)
    }

    @Test
    fun `returns NO comic books `() = runTest {
        // Given
        coEvery { repo.getComics() } returns ComicsResult.Failed

        // When
        val result = sut.execute()

        // Then
        assertTrue(result is ComicsResult.Failed)
    }
}