package com.biggerthannull.marvelheroes.data.comics.repository

import com.biggerthannull.marvelheroes.data.comics.datasource.ComicBooksDataSource
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicsResultDTO
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ThumbnailDTO
import com.biggerthannull.marvelheroes.domain.comics.repository.ComicsRepository
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicBookDetails
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicBookDetailsResult
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicsResult
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ReleasedComicBooks
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

    override suspend fun getComicBookDetails(id: Int): ComicBookDetailsResult {
        return dataSource.getComicBookDetails(id).fold(
            onSuccess = { response ->
                val result = mapComicBookDTOToDetails(response.first())
                ComicBookDetailsResult.Success(data = result)
            },
            onFailure = {
                ComicBookDetailsResult.Failed
            }
        )
    }


    private fun mapComicBookDTOToDomain(response: List<ComicsResultDTO>): List<ReleasedComicBooks> {
        return response.map { comicBookDto ->
            ReleasedComicBooks(
                id = comicBookDto.id,
                digitalId = comicBookDto.digitalId,
                title = comicBookDto.title,
                thumbnail = buildThumbnail(comicBookDto.thumbnail)
            )
        }
    }

    private fun mapComicBookDTOToDetails(response: ComicsResultDTO): ComicBookDetails {
        return ComicBookDetails(
            id = response.id,
            title = response.title,
            description = response.description,
            thumbnail = buildThumbnail(response.thumbnail)
        )
    }

    private fun buildThumbnail(thumbnail: ThumbnailDTO): String {
        return thumbnail.path + "." + thumbnail.extension

    }
}