package com.junemon.daggerinyourface.domain.di

import com.junemon.daggerinyourface.domain.repository.GameRepository
import com.junemon.daggerinyourface.domain.repository.PublisherRepository
import com.junemon.daggerinyourface.domain.usecase.GameUseCase
import com.junemon.daggerinyourface.domain.usecase.PublisherUseCase
import dagger.Module
import dagger.Provides

@Module
object RepositoryDomainModule {

    @Provides
    @JvmStatic
    fun provideGameUseCase(repository: GameRepository): GameUseCase {
        return GameUseCase(repository)
    }

    @Provides
    @JvmStatic
    fun providePublisherUseCase(repository: PublisherRepository): PublisherUseCase {
        return PublisherUseCase(repository)
    }
}
