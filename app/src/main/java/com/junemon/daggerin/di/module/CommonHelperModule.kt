package com.junemon.daggerin.di.module

import com.junemon.daggerin.util.classes.CommonHelperImpl
import com.junemon.daggerin.util.interfaces.CommonHelper
import dagger.Binds
import dagger.Module

@Module
abstract class CommonHelperModule {

    @Binds
    abstract fun bindsCommonHelper(commonHelper: CommonHelperImpl): CommonHelper
}