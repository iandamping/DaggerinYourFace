package com.junemon.daggerin.feature.game.module

import androidx.lifecycle.ViewModel
import com.junemon.daggerin.di.factory.ViewModelKey
import com.junemon.daggerin.feature.game.view.GameViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class GameActivityModule() {

    @Binds
    @IntoMap
    @ViewModelKey(GameViewModel::class)
    abstract fun bindUserViewModel(gameViewModel: GameViewModel): ViewModel
}
