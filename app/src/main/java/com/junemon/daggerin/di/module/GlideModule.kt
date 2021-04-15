package com.junemon.daggerin.di.module

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import dagger.Module
import dagger.Provides

/**
 * Created by Ian Damping on 23,June,2020
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Module
object GlideModule {

    @Provides
    @JvmStatic
    fun provideGlideRequestManager(application: Application): RequestManager {
        return Glide.with(application.applicationContext)
    }

    @Provides
    @JvmStatic
    fun provideGlideRequestOptions(): RequestOptions {
        return RequestOptions().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .placeholder(R.drawable.no_data)
    }
}