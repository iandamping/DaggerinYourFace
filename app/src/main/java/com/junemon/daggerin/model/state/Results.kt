package com.junemon.daggerin.model.state

sealed class Results<out R> {
    object Loading : Results<Nothing>()
    data class Success<out T>(val data: T) : Results<T>()
    data class Error(val message: String) : Results<Nothing>()
}