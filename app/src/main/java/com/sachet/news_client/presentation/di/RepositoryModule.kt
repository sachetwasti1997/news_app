package com.sachet.news_client.presentation.di

import com.sachet.news_client.data.reposirory.NewsRepositoryImpl
import com.sachet.news_client.data.reposirory.dataSource.NewsRemoteDataSource
import com.sachet.news_client.data.reposirory.dataSourceImpl.NewsRemoteDataSourceImpl
import com.sachet.news_client.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun getNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource
    ): NewsRepository{
        return NewsRepositoryImpl(newsRemoteDataSource)
    }

}