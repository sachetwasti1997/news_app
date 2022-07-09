package com.sachet.news_client.presentation.di

import com.sachet.news_client.data.api.NewsAPIService
import com.sachet.news_client.data.reposirory.dataSource.NewsRemoteDataSource
import com.sachet.news_client.data.reposirory.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun providesNewsRemoteDataSource(
        newsAPIService: NewsAPIService
    ): NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(newsAPIService)
    }

}