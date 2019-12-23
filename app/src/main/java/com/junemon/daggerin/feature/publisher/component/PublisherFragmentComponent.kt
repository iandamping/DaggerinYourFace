package com.junemon.daggerin.feature.publisher.component

import com.junemon.daggerin.feature.publisher.module.PublisherFragmentModule
import com.junemon.daggerin.feature.publisher.view.PublisherFragment
import dagger.Subcomponent

@Subcomponent(modules = [PublisherFragmentModule::class])
interface PublisherFragmentComponent {

    fun inject(fragment: PublisherFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): PublisherFragmentComponent
    }
}
