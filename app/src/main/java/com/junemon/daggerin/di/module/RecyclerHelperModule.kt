package com.junemon.daggerin.di.module

import com.junemon.daggerin.util.classes.RecyclerHelperImpl
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RecyclerHelperModule {

    @Binds
    abstract fun bindsRecyclerViewHelper(recyclerHelper: RecyclerHelperImpl): RecyclerHelper
}