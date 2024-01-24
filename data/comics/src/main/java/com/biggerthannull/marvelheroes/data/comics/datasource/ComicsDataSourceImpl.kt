package com.biggerthannull.marvelheroes.data.comics.datasource

import com.biggerthannull.marvelheroes.data.comics.api.ComicsApi
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicsDTO
import javax.inject.Inject

class ComicsDataSourceImpl @Inject constructor(
    private val api: ComicsApi
): ComicsDataSource {
    override fun getComics(): Result<List<ComicsDTO>> {
        TODO("Not yet implemented")
    }
}