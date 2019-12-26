package com.junemon.daggerinyourface.view.component

import com.junemon.daggerinyourface.di.module.PublisherPresentationModule
import com.junemon.daggerinyourface.view.publisher.detail.PublisherDetailFragment
import com.junemon.daggerinyourface.view.publisher.PublisherFragment
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
