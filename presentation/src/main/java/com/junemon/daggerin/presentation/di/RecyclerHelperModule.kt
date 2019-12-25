package com.junemon.daggerin.presentation.di.module

import com.junemon.daggerin.presentation.util.classes.RecyclerHelperImpl
import com.junemon.daggerin.presentation.util.interfaces.RecyclerHelper
import dagger.Binds
import dagger.Module

@Module
abstract class RecyclerHelperModule {

    @Binds
    abstract fun bindsRecyclerViewHelper(recyclerHelper: RecyclerHelperImpl): RecyclerHelper
}
