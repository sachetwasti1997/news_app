package com.sachet.news_client.data.util

/**
 * Sealed class allow us to represent hierarchy on the same file
 * Below is the generic object that contains data and the status about loadin the data
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
){
    class Success<T>(data: T): Resource<T>(data)
    class Loading<T>(data: T? = null): Resource<T>(data)
    class Error<T>(message: String?, data: T?= null): Resource<T>(data, message)
}
