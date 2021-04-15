package com.junemon.daggerin.feature.detail.publisher.module

import androidx.lifecycle.ViewModel
import com.junemon.daggerin.di.factory.ViewModelKey
import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PublisherDetailActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(PublisherDetailViewModel::class)
    abstract fun bindPublisherViewModel(publisherDetailViewModel: PublisherDetailViewModel): ViewModel
}
