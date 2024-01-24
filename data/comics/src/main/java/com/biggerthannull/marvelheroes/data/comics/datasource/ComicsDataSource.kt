package com.biggerthannull.marvelheroes.data.comics.datasource

import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicsDTO

interface ComicsDataSource {
    fun getComics(): Result<List<ComicsDTO>>
}