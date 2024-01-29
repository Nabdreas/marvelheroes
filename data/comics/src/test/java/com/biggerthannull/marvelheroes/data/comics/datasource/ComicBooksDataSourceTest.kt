package com.biggerthannull.marvelheroes.data.comics.datasource

import com.biggerthannull.marvelheroes.data.comics.api.ComicsApi
import com.biggerthannull.marvelheroes.data.comics.exceptions.ComicBooksResponseException
import com.biggerthannull.marvelheroes.data.comics.utils.FileUtil
import com.biggerthannull.marvelheroes.data.comics.utils.TestData.expectedComicsJSONResponse
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ComicBooksDataSourceTest {
    private lateinit var mockWebServer: MockWebServer

    private val validResponse =
        FileUtil.readFileWithoutNewLineFromResources("comicBooksResponse.json")

    @BeforeEach
    fun before() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
    }

    @AfterEach
    fun after() {
        mockWebServer.shutdown()
    }

    @Test
    fun `should return valid json response of comics books`() = runTest {
        // Given
        val sut = `given system under test`()
        `server 200 response`()

        // When
        val result = sut.getComics()

        // Then
        assertTrue(result.isSuccess)
        assertEquals(expectedComicsJSONResponse, result.getOrNull())
    }

    @Test
    fun `should return an error when requesting list of comic books`() = runTest {
        // Given
        val sut = `given system under test`()
        `server 401 response`()

        // When
        val result = sut.getComics()

        // Then
        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is ComicBooksResponseException)
    }

    private fun `given system under test`(): ComicBooksDataSource {
        return ComicBooksDataSourceImpl(buildApi())
    }

    private fun `server 200 response`() {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(validResponse)
        )
    }

    private fun `server 401 response`() {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(401)
                .setBody("")
        )
    }

    private fun buildApi(): ComicsApi {
        return Retrofit.Builder()
            .baseUrl(mockWebServer.url("comics/").toString())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ComicsApi::class.java)
    }


}