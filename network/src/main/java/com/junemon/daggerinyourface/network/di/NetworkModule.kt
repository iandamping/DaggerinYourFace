package com.junemon.daggerinyourface.network.di


import com.google.gson.GsonBuilder
import com.junemon.daggerinyourface.network.ApiInterface
import dagger.Module
import dagger.Provides
import java.util.concurrent.TimeUnit
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
object NetworkModule {
    private const val baseApi = "https://api.rawg.io/api/"
    @Provides
    @JvmStatic
    internal fun provideOkHttpClient(): OkHttpClient {
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
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .baseUrl(baseApi)
            .build()
    }

    @Provides
    @JvmStatic
    fun provideApiInterface(): ApiInterface {
        return provideRetrofit()
            .create(ApiInterface::class.java)
    }
}