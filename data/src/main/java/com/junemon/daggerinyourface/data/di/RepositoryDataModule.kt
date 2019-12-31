package com.junemon.daggerinyourface.data.di

import com.junemon.daggerinyourface.data.data.datasource.GameCacheDataSource
import com.junemon.daggerinyourface.data.data.datasource.GameRemoteDataSource
import com.junemon.daggerinyourface.data.data.datasource.PublisherCacheDataSource
import com.junemon.daggerinyourface.data.data.datasource.PublisherRemoteDataSource
import com.junemon.daggerinyourface.data.data.repository.GameRepositoryImpl
import com.junemon.daggerinyourface.data.data.repository.PublisherRepositoryImpl
import com.junemon.daggerinyourface.data.datasource.cache.GameCacheDataSourceImpl
import com.junemon.daggerinyourface.data.datasource.cache.PublisherCacheDataSourceImpl
import com.junemon.daggerinyourface.data.datasource.remote.GameRemoteDataSourceImpl
import com.junemon.daggerinyourface.data.datasource.remote.PublisherRemoteDataSourceImpl
import com.junemon.daggerinyourface.domain.repository.GameRepository
import com.junemon.daggerinyourface.domain.repository.PublisherRepository
import com.junemon.daggerinyourface.network.di.RetrofitHelperModule
import dagger.Binds
import dagger.Module

@Module(includes = [RetrofitHelperModule::class, DatabaseHelperModule::class])
abstract class RepositoryDataModule {

    @Binds
    abstract fun bindsGameRemoteDataSource(remoteSource: GameRemoteDataSourceImpl): GameRemoteDataSource

    @Binds
    abstract fun bindsGameCacheDataSource(cacheSource: GameCacheDataSourceImpl): GameCacheDataSource

    @Binds
    abstract fun bindsGameRepository(gameRepository: GameRepositoryImpl): GameRepository

    @Binds
    abstract fun bindsPublisherRemoteDataSource(remoteSource: PublisherRemoteDataSourceImpl): PublisherRemoteDataSource

    @Binds
    abstract fun bindsPublisherCacheDataSource(cacheSource: PublisherCacheDataSourceImpl): PublisherCacheDataSource

    @Binds
    abstract fun bindPublisherRepository(publisherRepository: PublisherRepositoryImpl): PublisherRepository
}
