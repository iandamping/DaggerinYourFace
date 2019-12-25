package com.junemon.daggerin.presentation.di.module

import com.junemon.daggerin.domain.repository.GameRepository
import com.junemon.daggerin.domain.repository.PublisherRepository
import com.junemon.daggerin.domain.usecase.GameUseCase
import com.junemon.daggerin.domain.usecase.PublisherUseCase
import dagger.Module
import dagger.Provides

@Module
object RepositoryPresentationModule {

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
