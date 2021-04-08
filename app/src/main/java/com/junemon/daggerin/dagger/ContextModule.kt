package com.junemon.daggerin.dagger

import android.content.Context
import com.junemon.daggerin.MainApplication
import dagger.Module
import dagger.Provides


/**
 * Created by Ian Damping on 08,April,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Module
object ContextModule {

    @Provides
    fun provideContext(application: MainApplication): Context {
        return application.applicationContext
    }

}