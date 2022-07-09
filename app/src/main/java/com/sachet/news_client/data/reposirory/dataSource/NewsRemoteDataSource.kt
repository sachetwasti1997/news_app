package com.sachet.news_client.data.reposirory.dataSource

import com.sachet.news_client.data.model.NewsResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadLines(): Response<NewsResponse>
}