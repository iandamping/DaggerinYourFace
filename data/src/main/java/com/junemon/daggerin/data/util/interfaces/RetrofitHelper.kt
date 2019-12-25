package com.junemon.daggerin.data.util.interfaces

import retrofit2.Call

interface RetrofitHelper {

    suspend fun <T> Call<T>.doOneShot(): T
}
