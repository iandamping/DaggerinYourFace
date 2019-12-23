package com.junemon.daggerin.feature.publisher.component

import com.junemon.daggerin.di.scope.PerActivities
import com.junemon.daggerin.feature.publisher.module.PublisherActivityModule
import com.junemon.daggerin.feature.publisher.view.PublisherActivity
import dagger.Subcomponent

@PerActivities
@Subcomponent(modules = [PublisherActivityModule::class])
interface PublisherActivityComponent {

    fun inject(activity: PublisherActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): PublisherActivityComponent
    }
}
