package com.biggerthannull.marvelheroes.data.comics.repository

import com.biggerthannull.marvelheroes.data.comics.datasource.ComicsDataSource
import com.biggerthannull.marvelheroes.domain.comics.repository.ComicsRepository
import com.biggerthannull.marvelheroes.domain.comics.usecase.ComicsResult
import javax.inject.Inject

class ComicsRepositoryImpl @Inject constructor(
    private val dataSource: ComicsDataSource
): ComicsRepository {
    override fun getComics(): ComicsResult {
        TODO("Not yet implemented")
    }
}