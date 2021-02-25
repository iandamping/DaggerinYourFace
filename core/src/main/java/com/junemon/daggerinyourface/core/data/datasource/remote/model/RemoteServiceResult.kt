package com.junemon.daggerinyourface.core.data.datasource.remote.model

sealed class RemoteServiceResult<out R> {
    data class Success<out T>(val data: T) : RemoteServiceResult<T>()
    data class Error(val exception: Exception) : RemoteServiceResult<Nothing>()
}