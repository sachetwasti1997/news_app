package com.sachet.news_client.presentation.di

import android.app.Application
import com.sachet.news_client.domain.usecase.GetNewsHeadLinesUseCase
import com.sachet.news_client.presentation.viewmodel.NewsViewModel
import com.sachet.news_client.presentation.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn
class FactoryModule {

    @Provides
    @Singleton
    fun providesViewModalFactory(
        application: Application,
        getNewsHeadLinesUseCase: GetNewsHeadLinesUseCase
    ):ViewModelFactory{
        return ViewModelFactory(application, getNewsHeadLinesUseCase)
    }

}