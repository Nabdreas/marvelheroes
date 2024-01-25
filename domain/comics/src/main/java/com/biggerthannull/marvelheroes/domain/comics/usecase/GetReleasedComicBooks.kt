package com.biggerthannull.marvelheroes.domain.comics.usecase

import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicsResult

interface GetReleasedComicBooks {
    suspend fun execute(): ComicsResult
}