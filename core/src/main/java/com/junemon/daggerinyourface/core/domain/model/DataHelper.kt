package com.junemon.daggerinyourface.core.domain.model


/**
 * Created by Ian Damping on 17,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
sealed class DataHelper<out T> {
    data class RemoteSourceValue<out T>(val data: T) : DataHelper<T>()
    data class RemoteSourceError(val exception: Exception) : DataHelper<Nothing>()
    object RemoteSourceEmpty : DataHelper<Nothing>()
}

sealed class ConsumeResult<out T> {
    data class ConsumeData<out T>(val data: T) : ConsumeResult<T>()
    data class ErrorHappen(val message: String?) : ConsumeResult<Nothing>()
    object Loading : ConsumeResult<Nothing>()
    object Complete : ConsumeResult<Nothing>()
}