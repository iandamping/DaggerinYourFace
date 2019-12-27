package com.junemon.daggerinyourface.presentation.di.module

import com.junemon.daggerinyourface.presentation.interfaces.LoadImageHelper
import com.junemon.daggerinyourface.presentation.util.classes.LoadImageHelperImpl
import dagger.Binds
import dagger.Module

@Module
abstract class LoadImageHelperModule {

    @Binds
    abstract fun bindsLoadImageHelper(loadImageHelper: LoadImageHelperImpl): LoadImageHelper
}
