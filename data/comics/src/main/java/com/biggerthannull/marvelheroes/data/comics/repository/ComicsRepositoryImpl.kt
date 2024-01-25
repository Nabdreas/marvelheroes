package com.biggerthannull.marvelheroes.data.comics.repository

import com.biggerthannull.marvelheroes.data.comics.datasource.ComicBooksDataSource
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicsResultDTO
import com.biggerthannull.marvelheroes.domain.comics.repository.ComicsRepository
import com.biggerthannull.marvelheroes.domain.comics.usecase.ComicsResult
import com.biggerthannull.marvelheroes.domain.comics.usecase.ReleasedComicBooks
import javax.inject.Inject

class ComicsRepositoryImpl @Inject constructor(
    private val dataSource: ComicBooksDataSource
) : ComicsRepository {
    override suspend fun getComics(): ComicsResult {
        return dataSource.getComics().fold(
            onSuccess = { response ->
                val result = mapComicBookDTOToDomain(response.data.results)
                ComicsResult.Success(data = result)
            },
            onFailure = {
                ComicsResult.Failed
            }
        )
    }

    private fun mapComicBookDTOToDomain(response: List<ComicsResultDTO>): List<ReleasedComicBooks> {
        return response.map { comicBook ->
            ReleasedComicBooks(
                id = comicBook.id,
                digitalId = comicBook.digitalId,
                title = comicBook.title
            )
        }
    }
}