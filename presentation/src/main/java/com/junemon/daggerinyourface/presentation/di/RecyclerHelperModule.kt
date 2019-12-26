package com.junemon.daggerinyourface.presentation.di.module

import com.junemon.daggerinyourface.presentation.util.classes.RecyclerHelperImpl
import com.junemon.daggerinyourface.presentation.util.interfaces.RecyclerHelper
import dagger.Binds
import dagger.Module

@Module
abstract class RecyclerHelperModule {

    @Binds
    abstract fun bindsRecyclerViewHelper(recyclerHelper: RecyclerHelperImpl): RecyclerHelper
}
