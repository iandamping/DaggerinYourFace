package com.junemon.daggerin.presentation.di.component

import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailFragment
import com.junemon.daggerin.feature.publisher.view.PublisherFragment
import com.junemon.daggerin.presentation.di.module.PublisherPresentationModule
import dagger.Subcomponent

@Subcomponent(modules = [PublisherPresentationModule::class])
interface PublisherPresentationComponent {

    fun inject(fragment: PublisherFragment)

    fun inject(fragment: PublisherDetailFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): PublisherPresentationComponent
    }
}
