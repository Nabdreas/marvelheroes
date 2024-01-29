package com.biggerthannull.marvelheroes.feature.feed

import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ReleasedComicBook

object ViewTestData {
    val releasedComicBook = ReleasedComicBook(
        id = 91992,
        digitalId = 56203,
        title = "Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)",
        thumbnail = "https://i.annihil.us/u/prod/marvel/i/mg/a/10/5ff386e1a2e88.jpg"
    )
}