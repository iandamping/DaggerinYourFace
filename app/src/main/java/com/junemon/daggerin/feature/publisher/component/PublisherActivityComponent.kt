package com.junemon.daggerin.feature.publisher.component

import com.junemon.daggerin.feature.publisher.module.PublisherActivityModule
import com.junemon.daggerin.feature.publisher.view.PublisherActivity
import com.junemon.daggerin.feature.publisher.view.PublisherPresenter
import com.junemon.daggerin.tutorial.dagger.scope.PerActivity
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [PublisherActivityModule::class])
interface PublisherActivityComponent {

    fun getRecyclerHelper(): RecyclerHelper

    fun getLoadImageHelper(): LoadImageHelper

    fun getPublisherPresenter(): PublisherPresenter

    fun inject(activity: PublisherActivity)
}