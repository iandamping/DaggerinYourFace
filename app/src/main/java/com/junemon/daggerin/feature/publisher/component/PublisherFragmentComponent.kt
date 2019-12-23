package com.junemon.daggerin.feature.publisher.component

import com.junemon.daggerin.feature.publisher.module.PublisherFragmentDetailModule
import com.junemon.daggerin.feature.publisher.view.PublisherFragment
import dagger.Subcomponent

@Subcomponent(modules = [PublisherFragmentDetailModule::class])
interface PublisherFragmentComponent {

    fun inject(fragment: PublisherFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): PublisherFragmentComponent
    }
}
