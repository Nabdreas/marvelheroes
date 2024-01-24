package com.biggerthannull.marvelheroes.domain.comics.repository

import com.biggerthannull.marvelheroes.domain.comics.usecase.ComicsResult

interface ComicsRepository {
    fun getComics(): ComicsResult
}