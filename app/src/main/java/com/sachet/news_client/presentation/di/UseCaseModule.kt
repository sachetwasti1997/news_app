package com.sachet.news_client.presentation.di

import com.sachet.news_client.domain.repository.NewsRepository
import com.sachet.news_client.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun providesGetNewsHeadLinesUseCase(
        newsRepository: NewsRepository
    ):GetNewsHeadLinesUseCase{
        return GetNewsHeadLinesUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun providesGetSavedNewsUseCase(
        newsRepository: NewsRepository
    ):GetSavedNewsUseCase{
        return GetSavedNewsUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun providesSaveNewsUseCase(
        newsRepository: NewsRepository
    ):SaveNewsUseCase{
        return SaveNewsUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun providesGetSearchedNewsUseCase(
        newsRepository: NewsRepository
    ):GetSearchedNewsUseCase{
        return GetSearchedNewsUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun providesDeleteSavedNewsUseCase(
        newsRepository: NewsRepository
    ): DeleteSavedNewsUseCase {
         return DeleteSavedNewsUseCase(newsRepository)
    }

}