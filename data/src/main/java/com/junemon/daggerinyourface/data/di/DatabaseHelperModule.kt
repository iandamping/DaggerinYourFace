package com.junemon.daggerinyourface.data.di.module

import com.junemon.daggerinyourface.data.util.classes.GameDaoHelperImpl
import com.junemon.daggerinyourface.data.util.classes.GamePagingDaoHelperImpl
import com.junemon.daggerinyourface.data.util.classes.PublisherDaoHelperImpl
import com.junemon.daggerinyourface.data.util.classes.PublisherPagingDaoHelperImpl
import com.junemon.daggerinyourface.data.util.interfaces.GameDaoHelper
import com.junemon.daggerinyourface.data.util.interfaces.GamePagingDaoHelper
import com.junemon.daggerinyourface.data.util.interfaces.PublisherDaoHelper
import com.junemon.daggerinyourface.data.util.interfaces.PublisherPagingDaoHelper
import dagger.Binds
import dagger.Module

@Module
abstract class DatabaseHelperModule {

    @Binds
    abstract fun bindsGameDaoHelper(gameDaoHelper: GameDaoHelperImpl): GameDaoHelper

    @Binds
    abstract fun bindsGamePaginationDaoHelper(gamePagingDaoHelper: GamePagingDaoHelperImpl): GamePagingDaoHelper

    @Binds
    abstract fun bindsPublisherDaoHelper(publisherDaoHelper: PublisherDaoHelperImpl): PublisherDaoHelper

    @Binds
    abstract fun bindsPublisherPaginationDaoHelper(publisherPagingDaoHelper: PublisherPagingDaoHelperImpl): PublisherPagingDaoHelper
}
