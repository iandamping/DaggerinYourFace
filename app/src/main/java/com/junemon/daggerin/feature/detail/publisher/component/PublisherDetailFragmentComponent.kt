package com.junemon.daggerin.feature.detail.publisher.component

import com.junemon.daggerin.feature.detail.publisher.module.PublisherDetailFragmentModule
import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailFragment
import dagger.Subcomponent

@Subcomponent(modules = [PublisherDetailFragmentModule::class])
interface PublisherDetailFragmentComponent {

    fun inject(fragment: PublisherDetailFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): PublisherDetailFragmentComponent
    }
}
