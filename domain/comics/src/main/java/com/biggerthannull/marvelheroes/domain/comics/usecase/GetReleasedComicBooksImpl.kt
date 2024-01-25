package com.biggerthannull.marvelheroes.domain.comics.usecase

import com.biggerthannull.marvelheroes.domain.comics.repository.ComicsRepository
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicsResult
import javax.inject.Inject

class GetReleasedComicBooksImpl @Inject constructor(
    private val repo: ComicsRepository
): GetReleasedComicBooks {
    override suspend fun execute(): ComicsResult {
        return repo.getComics()
    }
}