package com.junemon.daggerinyourface.core.data.datasource.remote.helper

import com.junemon.daggerinyourface.core.data.datasource.remote.model.RemoteServiceResult
import com.junemon.daggerinyourface.core.util.Constant.FAILED_NETWORK_RESPONSE
import com.junemon.daggerinyourface.core.util.Constant.FAILED_RESPONSE
import com.junemon.daggerinyourface.core.util.Constant.NULL_BODY
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException


abstract class BaseResponse {

    protected inline fun <T> doOneShots(call: () -> Response<T>): RemoteServiceResult<T> {
        try {
            val response = call.invoke()
            return if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    RemoteServiceResult.Success(body)
                } else {
                    RemoteServiceResult.Error(Exception(NULL_BODY))
                }
            } else return RemoteServiceResult.Error(Exception(FAILED_RESPONSE))

        } catch (e: Exception) {
            return when (e) {
                is IOException -> {
                    RemoteServiceResult.Error(Exception(FAILED_NETWORK_RESPONSE))
                }
                is SocketTimeoutException -> {
                    RemoteServiceResult.Error(Exception(FAILED_NETWORK_RESPONSE))
                }
                else -> {
                    RemoteServiceResult.Error(e)
                }
            }
        }

    }

}