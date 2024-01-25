package com.biggerthannull.marvelheroes.data.comics.repository

import com.biggerthannull.marvelheroes.data.comics.datasource.ComicBooksDataSource
import com.biggerthannull.marvelheroes.data.comics.utils.TestData.expectedComicsJSONResponse
import com.biggerthannull.marvelheroes.data.comics.utils.TestData.releasedComicBooks
import com.biggerthannull.marvelheroes.domain.comics.repository.ComicsRepository
import com.biggerthannull.marvelheroes.domain.comics.usecase.ComicsResult
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ComicsRepositoryTest {

    private val dataSource: ComicBooksDataSource = mockk()
    private val sut: ComicsRepository = ComicsRepositoryImpl(dataSource)


    @Test
    fun `should return list of released comic books`() = runTest {
        // Given
        coEvery { dataSource.getComics() } returns Result.success(expectedComicsJSONResponse)

        // When
        val result = sut.getComics()

        // Then
        assertTrue(result is ComicsResult.Success)
        assertEquals(listOf(releasedComicBooks), (result as ComicsResult.Success).data)
    }

    @Test
    fun `should return failed result for comic books`() = runTest {
        // Given
        coEvery { dataSource.getComics() } returns Result.failure(Exception("Completely failed"))

        // When
        val result = sut.getComics()

        // Then
        assertTrue(result is ComicsResult.Failed)
    }
}