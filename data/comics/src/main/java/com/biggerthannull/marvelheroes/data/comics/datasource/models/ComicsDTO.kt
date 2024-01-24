package com.biggerthannull.marvelheroes.data.comics.datasource.models

import androidx.annotation.Keep

@Keep
data class ComicsDTO(
    val data: ComicsDataDTO
)

@Keep
data class ComicsDataDTO(
    val result: ComicsResultDTO
)

@Keep
data class ComicsResultDTO(
    val title: String
)
