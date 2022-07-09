package com.sachet.news_client.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sachet.news_client.data.model.NewsResponse
import com.sachet.news_client.data.util.Resource
import com.sachet.news_client.domain.usecase.GetNewsHeadLinesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val app: Application,
    val getNewsHeadLinesUseCase: GetNewsHeadLinesUseCase
): AndroidViewModel(app) {
    val newsHeadLines: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    fun getHeadLines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadLines.postValue(Resource.Loading())
        val apiRes = getNewsHeadLinesUseCase.execute(country, page)
        newsHeadLines.postValue(apiRes)
    }
}