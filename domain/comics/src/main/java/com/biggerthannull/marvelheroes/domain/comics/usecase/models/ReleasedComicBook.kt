package com.biggerthannull.marvelheroes.domain.comics.usecase.models

data class ReleasedComicBook(
    val id: Int,
    val digitalId: Int,
    val title: String,
    val thumbnail: String
)
