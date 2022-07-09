package com.sachet.news_client.domain.usecase

import com.sachet.news_client.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
}