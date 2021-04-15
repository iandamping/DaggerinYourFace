package com.junemon.daggerin.feature.detail.game.module

import androidx.lifecycle.ViewModel
import com.junemon.daggerin.di.factory.ViewModelKey
import com.junemon.daggerin.feature.detail.game.view.GameDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class GameDetailActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(GameDetailViewModel::class)
    abstract fun bindUserViewModel(gameDetailViewModel: GameDetailViewModel): ViewModel
}
