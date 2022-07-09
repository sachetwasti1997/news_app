package com.sachet.news_client.data.reposirory.dataSource

import com.sachet.news_client.data.model.NewsResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadLines(country: String, page: Int): Response<NewsResponse>
}