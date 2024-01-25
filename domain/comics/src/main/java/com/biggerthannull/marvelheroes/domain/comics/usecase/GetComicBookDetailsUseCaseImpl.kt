package com.biggerthannull.marvelheroes.domain.comics.usecase

import com.biggerthannull.marvelheroes.domain.comics.repository.ComicsRepository
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ComicBookDetailsResult
import javax.inject.Inject

class GetComicBookDetailsUseCaseImpl @Inject constructor(
    private val repo: ComicsRepository
): GetComicBookDetailsUseCase {
    override suspend fun execute(id: Int): ComicBookDetailsResult {
        return repo.getComicBookDetails(id)
    }
}