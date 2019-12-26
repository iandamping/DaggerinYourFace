package com.junemon.daggerinyourface.data.di.module

import com.junemon.daggerinyourface.data.util.classes.RetrofitHelperImpl
import com.junemon.daggerinyourface.data.util.interfaces.RetrofitHelper
import dagger.Binds
import dagger.Module

@Module
abstract class RetrofitHelperModule {

    @Binds
    abstract fun bindsRetrofitHelper(retrofitHelper: RetrofitHelperImpl): RetrofitHelper
}
