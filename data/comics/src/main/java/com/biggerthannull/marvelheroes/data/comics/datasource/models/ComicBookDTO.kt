package com.biggerthannull.marvelheroes.data.comics.datasource.models

import androidx.annotation.Keep

@Keep
data class ComicBookDTO(
    val data: ComicsDataDTO
)

@Keep
data class ComicsDataDTO(
    val results: List<ComicsResultDTO>
)

@Keep
data class ComicsResultDTO(
    val id: Int,
    val digitalId: Int,
    val title: String
)
