package com.junemon.daggerin.di.module

import com.junemon.daggerin.util.classes.RetrofitHelperImpl
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RetrofitHelperModule {

    @Binds
    abstract fun bindsRetrofitHelper(retrofitHelper: RetrofitHelperImpl): RetrofitHelper
}