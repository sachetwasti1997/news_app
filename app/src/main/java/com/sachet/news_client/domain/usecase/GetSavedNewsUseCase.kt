package com.sachet.news_client.domain.usecase

import com.sachet.news_client.domain.repository.NewsRepository


class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute() = newsRepository.getSavedNews()
}