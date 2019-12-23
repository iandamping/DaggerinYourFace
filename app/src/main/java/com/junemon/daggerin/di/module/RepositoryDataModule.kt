package com.junemon.daggerin.di.module

import com.junemon.daggerin.data.data.datasource.GameCacheDataSource
import com.junemon.daggerin.data.data.datasource.GameRemoteDataSource
import com.junemon.daggerin.data.data.datasource.PublisherCacheDataSource
import com.junemon.daggerin.data.data.datasource.PublisherRemoteDataSource
import com.junemon.daggerin.data.data.repository.GameRepositoryImpl
import com.junemon.daggerin.data.data.repository.PublisherRepositoryImpl
import com.junemon.daggerin.data.datasource.cache.GameCacheDataSourceImpl
import com.junemon.daggerin.data.datasource.cache.PublisherCacheDataSourceImpl
import com.junemon.daggerin.data.datasource.remote.GameRemoteDataSourceImpl
import com.junemon.daggerin.data.datasource.remote.PublisherRemoteDataSourceImpl
import com.junemon.daggerin.domain.repository.GameRepository
import com.junemon.daggerin.domain.repository.PublisherRepository
import dagger.Binds
import dagger.Module

@Module
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
