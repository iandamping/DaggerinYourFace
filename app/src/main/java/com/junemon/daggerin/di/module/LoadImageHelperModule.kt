package com.junemon.daggerin.di.module

import com.junemon.daggerin.util.classes.LoadImageHelperImpl
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import dagger.Binds
import dagger.Module

@Module
abstract class LoadImageHelperModule {

    @Binds
    abstract fun bindsLoadImageHelper(loadImageHelper: LoadImageHelperImpl): LoadImageHelper
}