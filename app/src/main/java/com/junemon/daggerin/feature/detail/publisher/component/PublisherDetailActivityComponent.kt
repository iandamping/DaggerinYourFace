package com.junemon.daggerin.feature.detail.publisher.component

import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailActivity
import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailView
import dagger.BindsInstance
import dagger.Subcomponent


@Subcomponent
interface PublisherDetailActivityComponent {

    fun injectActivity(activity: PublisherDetailActivity)

    @Subcomponent.Factory
    interface Factory {
        fun inject(@BindsInstance publisherDetailView: PublisherDetailView): PublisherDetailActivityComponent
    }
}