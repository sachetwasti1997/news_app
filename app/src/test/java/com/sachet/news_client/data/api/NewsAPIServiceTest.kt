package com.sachet.news_client.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NewsAPIServiceTest {
    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    private fun enqueMockResponse(
        fileName: String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadLines_sentRequest_receivedExpected(){
        runBlocking {
            enqueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadLines("us", 1).body()
            val request = server.takeRequest()
            println(responseBody)
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=ade2307ef8ea4e53a89676326b5716a6")
        }
    }

    @Test
    fun getTopHeadLines_sentRequest_receivedCorrectPageSize(){
        runBlocking {
            enqueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadLines("us", 1).body()
            assertThat(responseBody).isNotNull()
            assertThat(responseBody?.articles?.size).isEqualTo(20)
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}