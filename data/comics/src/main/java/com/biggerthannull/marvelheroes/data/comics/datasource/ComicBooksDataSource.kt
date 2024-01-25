package com.biggerthannull.marvelheroes.data.comics.datasource

import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicBookDTO

interface ComicBooksDataSource {
    suspend fun getComics(): Result<ComicBookDTO>
}