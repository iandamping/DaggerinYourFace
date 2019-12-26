package com.junemon.daggerinyourface.di.module

import androidx.lifecycle.ViewModelProvider
import com.android.example.github.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
