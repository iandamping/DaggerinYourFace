package com.junemon.daggerin.di.module

import com.junemon.daggerin.util.classes.RetrofitHelperImpl
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import dagger.Binds
import dagger.Module

@Module
abstract class RetrofitHelperModule {

    @Binds
    abstract fun bindsRetrofitHelper(retrofitHelper: RetrofitHelperImpl): RetrofitHelper
}