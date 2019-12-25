package com.junemon.daggerin.presentation.di.module

import com.junemon.daggerin.presentation.util.classes.LoadImageHelperImpl
import com.junemon.daggerin.presentation.interfaces.LoadImageHelper
import dagger.Binds
import dagger.Module

@Module
abstract class LoadImageHelperModule {

    @Binds
    abstract fun bindsLoadImageHelper(loadImageHelper: LoadImageHelperImpl): LoadImageHelper
}
