package com.junemon.daggerin.data.di

import com.junemon.daggerin.data.util.classes.GameDaoHelperImpl
import com.junemon.daggerin.data.util.classes.PublisherDaoHelperImpl
import com.junemon.daggerin.data.util.interfaces.GameDaoHelper
import com.junemon.daggerin.data.util.interfaces.PublisherDaoHelper
import dagger.Binds
import dagger.Module

@Module
abstract class DatabaseHelperModule {

    @Binds
    abstract fun bindsGameDaoHelper(gameDaoHelper: GameDaoHelperImpl): GameDaoHelper

    @Binds
    abstract fun bindsPublisherDaoHelper(publisherDaoHelper: PublisherDaoHelperImpl): PublisherDaoHelper
}
