package com.junemon.daggerin.di.module

import com.junemon.daggerin.util.classes.GameDaoHelperImpl
import com.junemon.daggerin.util.interfaces.GameDaoHelper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseHelperModule {

    @Binds
    abstract fun bindsGameDaoHelper(gameDaoHelper: GameDaoHelperImpl): GameDaoHelper
}