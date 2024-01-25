package com.biggerthannull.marvelheroes.domain.comics.usecase

import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicsResult

interface GetReleasedComicBooksUseCase {
    suspend fun execute(): ComicsResult
}