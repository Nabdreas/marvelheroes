package com.biggerthannull.marvelheroes.data.comics.repository

import com.biggerthannull.marvelheroes.data.comics.datasource.ComicBooksDataSource
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicsResultDTO
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ThumbnailDTO
import com.biggerthannull.marvelheroes.domain.comics.repository.ComicsRepository
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicsResult
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ReleasedComicBook
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


    private fun mapComicBookDTOToDomain(response: List<ComicsResultDTO>): List<ReleasedComicBook> {
        return response.map { comicBookDto ->
            ReleasedComicBook(
                id = comicBookDto.id,
                digitalId = comicBookDto.digitalId,
                title = comicBookDto.title,
                thumbnail = buildThumbnail(comicBookDto.thumbnail)
            )
        }
    }

    private fun buildThumbnail(thumbnail: ThumbnailDTO): String {
        val nonSecureThumbnail = thumbnail.path + "." + thumbnail.extension
        return nonSecureThumbnail.replace("http://", "https://")

    }
}