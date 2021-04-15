package com.junemon.daggerin.feature.detail.publisher.component

import com.junemon.daggerin.feature.detail.publisher.module.PublisherDetailActivityModule
import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailActivity
import dagger.Subcomponent


@Subcomponent(modules = [PublisherDetailActivityModule::class])
interface PublisherDetailActivityComponent {

    fun inject(activity: PublisherDetailActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): PublisherDetailActivityComponent
    }
}
