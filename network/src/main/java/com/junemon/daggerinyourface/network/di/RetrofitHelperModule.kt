package com.junemon.daggerinyourface.network.di

import com.junemon.daggerinyourface.network.util.classes.RetrofitHelperImpl
import com.junemon.daggerinyourface.network.util.interfaces.RetrofitHelper
import dagger.Binds
import dagger.Module

@Module
abstract class RetrofitHelperModule {

    @Binds
    abstract fun bindsRetrofitHelper(retrofitHelper: RetrofitHelperImpl): RetrofitHelper
}
