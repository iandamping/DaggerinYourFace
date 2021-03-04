package com.junemon.daggerin.di.module

import com.junemon.daggerin.util.classes.LoadImageHelperImpl
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class LoadImageHelperModule {

    @Binds
    abstract fun bindsLoadImageHelper(loadImageHelper: LoadImageHelperImpl): LoadImageHelper
}