package com.sachet.news_client.domain.usecase

import com.sachet.news_client.domain.repository.NewsRepository

class GetNewsHeadLinesUseCase(
    private val newsRepository: NewsRepository
) {
}