package com.biggerthannull.marvelheroes.domain.comics.usecase.models

sealed class ComicBookDetailsResult {
    data object Failed : ComicBookDetailsResult()
    class Success(val data: ComicBookDetails) : ComicBookDetailsResult()
}