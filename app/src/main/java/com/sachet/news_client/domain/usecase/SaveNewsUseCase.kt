package com.sachet.news_client.domain.usecase

import com.sachet.news_client.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
}