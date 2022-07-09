package com.sachet.news_client.data.reposirory.dataSourceImpl

import com.sachet.news_client.data.api.NewsAPIService
import com.sachet.news_client.data.model.NewsResponse
import com.sachet.news_client.data.reposirory.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int
) : NewsRemoteDataSource {
    override suspend fun getTopHeadLines(): Response<NewsResponse>{
        return newsAPIService.getTopHeadLines(country, page)
    }
}