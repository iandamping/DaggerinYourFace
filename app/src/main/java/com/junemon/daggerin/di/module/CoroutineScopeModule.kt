package com.junemon.daggerin.di.module

import com.junemon.daggerin.di.qualifier.DefaultApplicationCoroutineScope
import com.junemon.daggerin.di.qualifier.DefaultDispatcher
import com.junemon.daggerin.di.qualifier.MainApplicationCoroutineScope
import com.junemon.daggerin.di.qualifier.MainDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * Created by Ian Damping on 25,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
@Module
@InstallIn(SingletonComponent::class)
object CoroutineScopeModule {

    @DefaultApplicationCoroutineScope
    @Provides
    fun providesDefaultApplicationScope(
        @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(SupervisorJob() + defaultDispatcher)


    @MainApplicationCoroutineScope
    @Provides
    fun providesMainApplicationScope(
        @MainDispatcher mainDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(SupervisorJob() + mainDispatcher)
}