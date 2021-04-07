package com.junemon.daggerin.feature.main.model


/**
 * Created by Ian Damping on 25,March,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
sealed class MainActivityViewModel<out T> {
    object Loading : MainActivityViewModel<Nothing>()
    class Result<R>(val data:R) : MainActivityViewModel<R>()
    object EmptyItem : MainActivityViewModel<Nothing>()
    object Complete : MainActivityViewModel<Nothing>()
    class Error(val message: String) : MainActivityViewModel<Nothing>()
}