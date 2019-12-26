package com.junemon.daggerinyourface.data.di.module

import com.junemon.daggerinyourface.data.util.classes.GameDaoHelperImpl
import com.junemon.daggerinyourface.data.util.classes.PublisherDaoHelperImpl
import com.junemon.daggerinyourface.data.util.interfaces.GameDaoHelper
import com.junemon.daggerinyourface.data.util.interfaces.PublisherDaoHelper
import dagger.Binds
import dagger.Module

@Module
abstract class DatabaseHelperModule {

    @Binds
    abstract fun bindsGameDaoHelper(gameDaoHelper: GameDaoHelperImpl): GameDaoHelper

    @Binds
    abstract fun bindsPublisherDaoHelper(publisherDaoHelper: PublisherDaoHelperImpl): PublisherDaoHelper
}
