package com.junemon.daggerin.di.module

import com.google.gson.GsonBuilder
import com.junemon.daggerin.BuildConfig
import com.junemon.daggerin.di.scope.ApplicationScope
import com.junemon.daggerin.network.ApiInterface
import dagger.Module
import dagger.Provides
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @JvmStatic
    @ApplicationScope
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .dispatcher(Dispatcher().apply {
                maxRequests = 20
                maxRequestsPerHost = 20
            })
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor { chain ->
                chain.run { proceed(this.request().newBuilder().build()) }
            }
        return okHttpBuilder.build()
    }

    @Provides
    @JvmStatic
    @ApplicationScope
    fun provideApiInterface(okHttpClient: OkHttpClient): ApiInterface {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .baseUrl(BuildConfig.baseApi)
            .build()
            .create(ApiInterface::class.java)
    }

}

