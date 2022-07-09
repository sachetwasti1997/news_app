package com.sachet.news_client.data.reposirory

import com.sachet.news_client.data.model.Article
import com.sachet.news_client.data.model.NewsResponse
import com.sachet.news_client.data.reposirory.dataSource.NewsRemoteDataSource
import com.sachet.news_client.data.util.Resource
import com.sachet.news_client.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {

    private fun responseToResource(response: Response<NewsResponse>): Resource<NewsResponse>{
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getNewsHeadLines(): Resource<NewsResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadLines())
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<NewsResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}