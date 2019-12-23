package com.junemon.daggerin.di.module

import com.junemon.daggerin.util.classes.RecyclerHelperImpl
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import dagger.Binds
import dagger.Module

@Module
abstract class RecyclerHelperModule {

    @Binds
    abstract fun bindsRecyclerViewHelper(recyclerHelper: RecyclerHelperImpl): RecyclerHelper
}
