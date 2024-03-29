package com.biggerthannull.marvelheroes.data.comics.api

import com.biggerthannull.marvelheroes.data.comics.BuildConfig
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicBookDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicsApi {
    @GET("comics")
    suspend fun getComics(
        @Query("ts") ts: String = BuildConfig.MARVEL_TS,
        @Query("apikey") apiKey: String = BuildConfig.MARVEL_API_KEY,
        @Query("hash") hash: String = BuildConfig.MARVEL_HAS,
        @Query("formatType") formatType: String = "comic",
        @Query("orderBy") orderBy: String = "-onsaleDate",
        @Query("limit") limit: Int = 15
    ): Response<ComicBookDTO>

    @GET("comics/{id}")
    suspend fun getComicBook(
        @Path("id") id: Int,
        @Query("ts") ts: String = BuildConfig.MARVEL_TS,
        @Query("apikey") apiKey: String = BuildConfig.MARVEL_API_KEY,
        @Query("hash") hash: String = BuildConfig.MARVEL_HAS
    ): Response<ComicBookDTO>
}