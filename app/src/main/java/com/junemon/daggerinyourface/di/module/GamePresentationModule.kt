package com.junemon.daggerinyourface.di.module

import androidx.lifecycle.ViewModel
import com.android.example.github.di.ViewModelKey
import com.junemon.daggerinyourface.presentation.vm.GamePresentationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class GamePresentationModule {
    @Binds
    @IntoMap
    @ViewModelKey(GamePresentationViewModel::class)
    abstract fun bindGamePresentationViewModel(gameViewModel: GamePresentationViewModel): ViewModel
}
