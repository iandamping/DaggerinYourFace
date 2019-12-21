package com.junemon.daggerin.feature.publisher.component

import com.junemon.daggerin.di.scope.PerActivities
import com.junemon.daggerin.feature.publisher.module.PublisherFragmentModule
import com.junemon.daggerin.feature.publisher.view.PublisherFragment
import com.junemon.daggerin.feature.publisher.view.PublisherView
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [PublisherFragmentModule::class])
interface PublisherFragmentComponent {

    fun inject(fragment: PublisherFragment)

    @Subcomponent.Factory
    interface Factory {
        fun inject(@BindsInstance publisherView: PublisherView): PublisherFragmentComponent
    }
}