package com.junemon.daggerin.presentation.di.module

import androidx.lifecycle.ViewModel
import com.android.example.github.di.ViewModelKey
import com.junemon.daggerin.presentation.vm.PublisherPresentationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PublisherPresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(PublisherPresentationViewModel::class)
    abstract fun bindPublisherPresentationViewModel(publisherViewModel: PublisherPresentationViewModel): ViewModel
}
