package com.biggerthannull.marvelheroes.data.comics.api

import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicsDTO
import retrofit2.Response
import retrofit2.http.GET

interface ComicsApi {

    @GET
    fun getComics(): Response<ComicsDTO>
}