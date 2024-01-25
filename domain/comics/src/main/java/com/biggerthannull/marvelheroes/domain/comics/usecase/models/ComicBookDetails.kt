package com.biggerthannull.marvelheroes.domain.comics.usecase.models

data class ComicBookDetails(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: String
)
