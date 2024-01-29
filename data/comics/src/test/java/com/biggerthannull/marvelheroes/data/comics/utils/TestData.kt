package com.biggerthannull.marvelheroes.data.comics.utils

import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicBookDTO
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicsDataDTO
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicsResultDTO
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ThumbnailDTO
import com.biggerthannull.marvelheroes.domain.comics.usecase.models.ReleasedComicBook

object TestData {
    val comicBook = ComicsResultDTO(
        id = 91992,
        digitalId = 56203,
        title = "Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)",
        description = "Collects Fantastic Four (2018) #1-11, Fantastic Four Wedding Special (2018) #1. The Fantastic Four is the World’s Greatest Comics Magazine — and superstar writer Dan Slott is about to show you why! After being separated across dimensions, the Thing, the Human Torch, the Invisible Woman and Mister Fantastic reunite at long last! But as Reed and Sue return home with their children, they find that big things have changed! Ben Grimm and Alicia Masters have major plans of their own — like a wedding, years in the making! And a new fabulous foursome, the Fantastix, are muscling in on the scene! But now that the FF are back, can Doctor Doom be far behind? And what about Galactus? Brace yourself for the World-Eater vs. the Lord of Latveria, with the fate of the planet hanging in the balance!",
        thumbnail = ThumbnailDTO(
            path = "http://i.annihil.us/u/prod/marvel/i/mg/a/10/5ff386e1a2e88",
            extension = "jpg"
        )
    )

    val expectedComicsJSONResponse = ComicBookDTO(
        data = ComicsDataDTO(
            results = listOf(comicBook)
        )
    )

    val releasedComicBook = ReleasedComicBook(
        id = 91992,
        digitalId = 56203,
        title = "Fantastic Four by Dan Slott Vol. 1 (Trade Paperback)",
        thumbnail = "https://i.annihil.us/u/prod/marvel/i/mg/a/10/5ff386e1a2e88.jpg"
    )
}