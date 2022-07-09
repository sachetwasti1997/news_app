package com.sachet.news_client.domain.usecase

import com.sachet.news_client.data.model.NewsResponse
import com.sachet.news_client.data.util.Resource
import com.sachet.news_client.domain.repository.NewsRepository

class GetNewsHeadLinesUseCase(
    private val newsRepository: NewsRepository
) {
    suspend fun execute() = newsRepository.getNewsHeadLines()
}