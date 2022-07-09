package com.sachet.news_client.domain.repository

import com.sachet.news_client.data.model.Article
import com.sachet.news_client.data.model.NewsResponse
import com.sachet.news_client.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsHeadLines(country: String, page: Int): Resource<NewsResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<NewsResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
    /**
     * A flow is a coroutine that can emit multiple values sequentially
     * In view modal we will collect this data as a stream of data and emit it as live data
     * since the function returns data stream we dont need to write it as suspending
     */
}