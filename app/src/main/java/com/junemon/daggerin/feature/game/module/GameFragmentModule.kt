package com.junemon.daggerin.feature.game.module

import androidx.lifecycle.ViewModel
import com.android.example.github.di.ViewModelKey
import com.junemon.daggerin.feature.game.view.GameViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class GameFragmentModule() {

    @Binds
    @IntoMap
    @ViewModelKey(GameViewModel::class)
    abstract fun bindUserViewModel(gameViewModel: GameViewModel): ViewModel
}
