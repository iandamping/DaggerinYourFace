package com.junemon.daggerin.feature.detail.publisher.component

import com.junemon.daggerin.di.scope.PerActivities
import com.junemon.daggerin.feature.detail.publisher.module.PublisherDetailFragmentModule
import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailFragment
import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailView
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [PublisherDetailFragmentModule::class])
interface PublisherDetailFragmentComponent {

    fun injectFragment(fragment: PublisherDetailFragment)

    @Subcomponent.Factory
    interface Factory {
        fun inject(@BindsInstance publisherDetailView: PublisherDetailView): PublisherDetailFragmentComponent
    }
}