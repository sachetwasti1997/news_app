package com.sachet.news_client.domain.usecase

import com.sachet.news_client.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery: String) = newsRepository.getSearchedNews(searchQuery)
}