package com.junemon.daggerin.feature.publisher.component

import com.junemon.daggerin.di.scope.PerActivities
import com.junemon.daggerin.feature.publisher.module.PublisherActivityModule
import com.junemon.daggerin.feature.publisher.view.PublisherActivity
import com.junemon.daggerin.feature.publisher.view.PublisherView
import dagger.BindsInstance
import dagger.Subcomponent

@PerActivities
@Subcomponent(modules = [PublisherActivityModule::class])
interface PublisherActivityComponent {

    /*
    we dont need this function anymore, dagger provide this for us to use
    
    fun getRecyclerHelper(): RecyclerHelper

    fun getLoadImageHelper(): LoadImageHelper

    fun getPublisherPresenter(): PublisherPresenter
*/

    fun injectActivity(activity: PublisherActivity)

    @Subcomponent.Factory
    interface Factory {
        fun inject(@BindsInstance publisherView: PublisherView): PublisherActivityComponent
    }
}