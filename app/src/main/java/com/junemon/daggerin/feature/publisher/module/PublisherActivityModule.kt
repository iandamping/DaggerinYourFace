package com.junemon.daggerin.feature.publisher.module

import androidx.lifecycle.ViewModel
import com.android.example.github.di.ViewModelKey
import com.junemon.daggerin.feature.publisher.view.PublisherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PublisherActivityModule() {
    @Binds
    @IntoMap
    @ViewModelKey(PublisherViewModel::class)
    abstract fun bindUserViewModel(publisherViewModel: PublisherViewModel): ViewModel
}
