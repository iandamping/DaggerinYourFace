package com.junemon.daggerin.di.module

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.junemon.daggerin.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object GlideModule {
    @Provides
    @JvmStatic
    @Singleton
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions().placeholder(R.drawable.preview_image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.no_data)
    }

    /*Application is provided when this module is used in appcomponent*/
    @Provides
    @JvmStatic
    @Singleton
    fun provideGlideInstance(
        application: Application,
        requestOptions: RequestOptions
    ): RequestManager {
        return Glide.with(application).setDefaultRequestOptions(requestOptions)
    }
}