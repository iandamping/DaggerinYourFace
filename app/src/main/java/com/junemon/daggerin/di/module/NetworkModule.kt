package com.junemon.daggerin.di.module

import com.google.gson.GsonBuilder
import com.junemon.daggerin.BuildConfig
import com.junemon.daggerin.network.ApiInterface
import dagger.Module
import dagger.Provides
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
object NetworkModule {

        @Provides
        @JvmStatic
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
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.baseApi)
                .build()
        }


        @Provides
        @JvmStatic
        fun provideApiInterface(): ApiInterface {
            return provideRetrofit().create(ApiInterface::class.java)
        }


}

/*
@Module
class ApiInterfaceModule{
    @Provides
    fun provideApiInterface(): ApiInterface {
        return provideRetrofit().create(ApiInterface::class.java)
    }
}*/
