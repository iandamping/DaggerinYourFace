package com.junemon.daggerin.feature.detail.game.view.module

import androidx.lifecycle.ViewModel
import com.android.example.github.di.ViewModelKey
import com.junemon.daggerin.feature.detail.game.view.GameDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class GameFragmentDetailModule {
    @Binds
    @IntoMap
    @ViewModelKey(GameDetailViewModel::class)
    abstract fun bindUserViewModel(gameDetailViewModel: GameDetailViewModel): ViewModel
}