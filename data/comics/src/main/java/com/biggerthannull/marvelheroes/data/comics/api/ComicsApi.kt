package com.biggerthannull.marvelheroes.data.comics.api

import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicBookDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicsApi {
    @GET("/comics")
    suspend fun getComics(
        @Query("ts") ts: String,
        @Query("api_key") apiKey: String,
        @Query("hash") hash: String,
        @Query("orderBy") orderBy: String = "title",
        @Query("limit") limit: Int = 1
    ): Response<ComicBookDTO>
}