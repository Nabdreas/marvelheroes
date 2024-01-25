package com.biggerthannull.marvelheroes.domain.comics.utils

import com.biggerthannull.marvelheroes.domain.comics.usecase.ReleasedComicBooks

object DomainTestData {
    val releasedComicBooks = ReleasedComicBooks(
        id = 91992,
        digitalId = 56203,
        title = "Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)"
    )
}