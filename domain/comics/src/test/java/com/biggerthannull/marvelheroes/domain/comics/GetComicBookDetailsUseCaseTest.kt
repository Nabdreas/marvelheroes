package com.biggerthannull.marvelheroes.domain.comics

import com.biggerthannull.marvelheroes.domain.comics.repository.ComicsRepository
import com.biggerthannull.marvelheroes.domain.comics.usecase.GetComicBookDetailsUseCase
import com.biggerthannull.marvelheroes.domain.comics.usecase.GetComicBookDetailsUseCaseImpl
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicBookDetailsResult
import com.biggerthannull.marvelheroes.domain.comics.utils.DomainTestData.comicBookDetails
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GetComicBookDetailsUseCaseTest {

    private val repo: ComicsRepository = mockk()
    private val sut: GetComicBookDetailsUseCase = GetComicBookDetailsUseCaseImpl(repo)

    @Test
    fun `should return comic book details`() = runTest {
        // Given
        coEvery { repo.getComicBookDetails(54322) } returns ComicBookDetailsResult.Success(
            data = comicBookDetails
        )

        // When
        val result = sut.execute(54322)

        // Then
        assertEquals(comicBookDetails, (result as ComicBookDetailsResult.Success).data)
    }

    @Test
    fun `should return failed result for comic book details`() = runTest {
        // Given
        coEvery { repo.getComicBookDetails(54322) } returns ComicBookDetailsResult.Failed

        // When
        val result = sut.execute(54322)

        // Then
        assertTrue(result is ComicBookDetailsResult.Failed)
    }
}