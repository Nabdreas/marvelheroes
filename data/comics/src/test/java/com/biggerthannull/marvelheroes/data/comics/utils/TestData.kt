package com.biggerthannull.marvelheroes.data.comics.utils

import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicBookDTO
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicsDataDTO
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicsResultDTO
import com.biggerthannull.marvelheroes.domain.comics.usecase.ReleasedComicBooks

object TestData {
    private val comicBook = ComicsResultDTO(
        id = 91992,
        digitalId = 56203,
        title = "Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)"
    )

    val expectedComicsJSONResponse = ComicBookDTO(
        data = ComicsDataDTO(
            results = listOf(comicBook)
        )
    )

    val releasedComicBooks = ReleasedComicBooks(
        id = 91992,
        digitalId = 56203,
        title = "Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)"
    )
}