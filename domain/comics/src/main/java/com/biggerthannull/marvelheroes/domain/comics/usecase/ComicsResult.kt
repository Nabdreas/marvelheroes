package com.biggerthannull.marvelheroes.domain.comics.usecase

sealed class ComicsResult {
    data object Failed : ComicsResult()
    class Success(val data: List<ReleasedComicBooks>) : ComicsResult()
}