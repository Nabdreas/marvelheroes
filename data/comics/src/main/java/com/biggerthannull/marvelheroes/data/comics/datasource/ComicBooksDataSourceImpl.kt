package com.biggerthannull.marvelheroes.data.comics.datasource

import com.biggerthannull.marvelheroes.data.comics.BuildConfig
import com.biggerthannull.marvelheroes.data.comics.api.ComicsApi
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicBookDTO
import com.biggerthannull.marvelheroes.data.comics.datasource.models.ComicsResultDTO
import com.biggerthannull.marvelheroes.data.comics.exceptions.ComicBookDetailsException
import com.biggerthannull.marvelheroes.data.comics.exceptions.ComicBooksResponseException
import javax.inject.Inject

class ComicBooksDataSourceImpl @Inject constructor(
    private val api: ComicsApi
) : ComicBooksDataSource {
    override suspend fun getComics(): Result<ComicBookDTO> {
        return try {
            val response = api.getComics(
                ts = BuildConfig.MARVEL_TS,
                apiKey = BuildConfig.MARVEL_API_KEY,
                hash = BuildConfig.MARVEL_HAS
            )
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.success(body)
            } else {
                Result.failure(ComicBooksResponseException("Whoops failed to get comics"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getComicBookDetails(id: Int): Result<List<ComicsResultDTO>> {
        return try {
            val response = api.getComicBook(id)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.success(body.data.results)
            } else {
                Result.failure(ComicBookDetailsException("Whoops failed to get comics"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}