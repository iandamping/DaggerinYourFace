package com.junemon.daggerinyourface.model.domain

sealed class ResultToConsume<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : ResultToConsume<T>(data)
    class Loading<T>(data: T? = null) : ResultToConsume<T>(data)
    class Error<T>(message: String, data: T? = null) : ResultToConsume<T>(data, message)
}

sealed class Results<out R>() {
    data class Success<out T>(val data: T) : Results<T>()
    object Loading : Results<Nothing>()
    data class Error(val exception: Exception) : Results<Nothing>()
}

data class ResultRemoteToConsume<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): ResultRemoteToConsume<T> {
            return ResultRemoteToConsume(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(message: String, data: T? = null): ResultRemoteToConsume<T> {
            return ResultRemoteToConsume(
                Status.ERROR,
                data,
                message
            )
        }

        fun <T> loading(data: T? = null): ResultRemoteToConsume<T> {
            return ResultRemoteToConsume(
                Status.LOADING,
                data,
                null
            )
        }
    }
}
