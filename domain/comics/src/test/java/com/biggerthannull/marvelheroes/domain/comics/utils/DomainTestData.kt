package com.biggerthannull.marvelheroes.domain.comics.utils

import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ReleasedComicBook

object DomainTestData {
    val releasedComicBook = ReleasedComicBook(
        id = 91992,
        digitalId = 56203,
        title = "Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)",
        thumbnail = "http://i.annihil.us/u/prod/marvel/i/mg/a/10/5ff386e1a2e88.jpg"
    )
}