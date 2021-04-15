package com.junemon.daggerin.feature.publisher.component

import com.junemon.daggerin.feature.publisher.view.PublisherActivity
import com.junemon.daggerin.feature.publisher.view.PublisherView
import dagger.BindsInstance
import dagger.Subcomponent


@Subcomponent
interface PublisherActivityComponent {

    fun injectActivity(activity: PublisherActivity)

    @Subcomponent.Factory
    interface Factory {
        fun inject(@BindsInstance publisherView: PublisherView): PublisherActivityComponent
    }
}