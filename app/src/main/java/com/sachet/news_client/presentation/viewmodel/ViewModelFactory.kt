package com.sachet.news_client.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sachet.news_client.domain.usecase.GetNewsHeadLinesUseCase

/**
 * So if I have a ViewModel with multiple arguments, then I need to use a Factory that I can pass
 * to ViewModelProviders to use when an instance of MyViewModel is required.
 */
class ViewModelFactory(
    private val app: Application,
    val getNewsHeadLinesUseCase: GetNewsHeadLinesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadLinesUseCase
        ) as T
    }
}