package com.junemon.daggerinyourface.di.module

import androidx.lifecycle.ViewModel
import com.android.example.github.di.ViewModelKey
import com.junemon.daggerinyourface.presentation.vm.PublisherPresentationViewModel
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
