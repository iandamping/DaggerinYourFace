package com.junemon.daggerin.view.component

import com.junemon.daggerin.di.module.PublisherPresentationModule
import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailFragment
import com.junemon.daggerin.feature.publisher.view.PublisherFragment
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
