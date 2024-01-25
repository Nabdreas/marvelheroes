package com.biggerthannull.marvelheroes.data.comics.datasource

import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicBookDTO
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicsResultDTO

interface ComicBooksDataSource {
    suspend fun getComics(): Result<ComicBookDTO>

    suspend fun getComicBookDetails(id: Int): Result<List<ComicsResultDTO>>
}