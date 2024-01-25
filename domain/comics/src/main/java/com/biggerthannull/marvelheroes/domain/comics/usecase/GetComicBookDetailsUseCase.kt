package com.biggerthannull.marvelheroes.domain.comics.usecase

import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicBookDetailsResult

interface GetComicBookDetailsUseCase {
    suspend fun execute(id: Int): ComicBookDetailsResult
}