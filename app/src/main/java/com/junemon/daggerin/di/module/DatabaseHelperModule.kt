package com.junemon.daggerin.di.module

import com.junemon.daggerin.util.classes.GameDaoHelperImpl
import com.junemon.daggerin.util.classes.PublisherDaoHelperImpl
import com.junemon.daggerin.util.interfaces.GameDaoHelper
import com.junemon.daggerin.util.interfaces.PublisherDaoHelper
import dagger.Binds
import dagger.Module

@Module
abstract class DatabaseHelperModule {

    @Binds
    abstract fun bindsGameDaoHelper(gameDaoHelper: GameDaoHelperImpl): GameDaoHelper

    @Binds
    abstract fun bindsPublisherDaoHelper(publisherDaoHelper: PublisherDaoHelperImpl): PublisherDaoHelper
}
