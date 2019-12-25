package com.junemon.daggerin.di.module

import androidx.lifecycle.ViewModel
import com.android.example.github.di.ViewModelKey
import com.junemon.daggerin.presentation.vm.GamePresentationViewModel
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
