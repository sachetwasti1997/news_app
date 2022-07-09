package com.sachet.news_client.data.api

import com.sachet.news_client.BuildConfig
import com.sachet.news_client.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadLines(
        @Query("country")
        country:String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.API_KEY
    ): Response<NewsResponse>
}