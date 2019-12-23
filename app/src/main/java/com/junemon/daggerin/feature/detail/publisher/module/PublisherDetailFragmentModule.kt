package com.junemon.daggerin.feature.detail.publisher.module

import androidx.lifecycle.ViewModel
import com.android.example.github.di.ViewModelKey
import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PublisherDetailFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(PublisherDetailViewModel::class)
    abstract fun bindPublisherViewModel(publisherDetailViewModel: PublisherDetailViewModel): ViewModel
}
