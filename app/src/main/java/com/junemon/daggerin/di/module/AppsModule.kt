package com.junemon.daggerin.di.module

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.junemon.daggerin.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppsModule() {

    @Module
    companion object {
        @Provides
        @JvmStatic
        @Singleton
        fun provideRequestOptions(): RequestOptions {
            return RequestOptions().placeholder(R.drawable.preview_image)
                .error(R.drawable.no_data)
        }

        /*Application is provided when this module is used in appcomponent*/
        @Provides
        @JvmStatic
        @Singleton
        fun provideGlideInstance(application: Application, requestOptions: RequestOptions): RequestManager {
            return Glide.with(application).setDefaultRequestOptions(requestOptions)
        }
    }
}