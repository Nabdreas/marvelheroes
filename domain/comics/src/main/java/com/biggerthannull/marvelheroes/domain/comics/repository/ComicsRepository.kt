package com.biggerthannull.marvelheroes.domain.comics.repository

import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicBookDetailsResult
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicsResult

interface ComicsRepository {
    suspend fun getComics(): ComicsResult
    suspend fun getComicBookDetails(id: Int): ComicBookDetailsResult
}