package com.junemon.daggerin.data.di

import com.junemon.daggerin.data.util.classes.RetrofitHelperImpl
import com.junemon.daggerin.data.util.interfaces.RetrofitHelper
import dagger.Binds
import dagger.Module

@Module
abstract class RetrofitHelperModule {

    @Binds
    abstract fun bindsRetrofitHelper(retrofitHelper: RetrofitHelperImpl): RetrofitHelper
}
