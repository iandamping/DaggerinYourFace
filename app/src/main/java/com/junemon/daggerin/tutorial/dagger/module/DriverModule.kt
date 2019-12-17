package com.junemon.daggerin.tutorial.dagger.module

import com.junemon.daggerin.tutorial.model.Driver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DriverModule {

    /*Static function in java that converted in kotlin, it feels weird*/
    @Module
    companion object{
        @Provides
        @JvmStatic
        @Singleton
        fun provideDriver():Driver = Driver()
    }

}