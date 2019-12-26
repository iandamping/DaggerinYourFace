package com.junemon.daggerinyourface.data.util.classes

import com.junemon.daggerinyourface.data.util.interfaces.RetrofitHelper
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitHelperImpl @Inject constructor() :
    RetrofitHelper {

    @ExperimentalCoroutinesApi
    override suspend fun <T> Call<T>.doOneShot(): T =
        suspendCancellableCoroutine { cancellableContinuation ->

            this.enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    cancellableContinuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body != null) {
                            cancellableContinuation.resume(body)
                        }
                    }
                }
            })
            cancellableContinuation.invokeOnCancellation {
                this.cancel()
            }
        }
}
