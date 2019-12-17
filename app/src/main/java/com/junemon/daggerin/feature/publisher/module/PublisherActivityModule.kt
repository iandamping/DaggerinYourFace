package com.junemon.daggerin.feature.publisher.module

import com.junemon.daggerin.feature.publisher.view.PublisherPresenter
import com.junemon.daggerin.feature.publisher.view.PublisherView
import com.junemon.daggerin.network.ApiInterface
import dagger.Module
import dagger.Provides

@Module
class PublisherActivityModule(private val mView: PublisherView) {

    @Provides
    fun providePublisherView(): PublisherView = mView

    @Provides
    fun providePublisherPresenter(mView: PublisherView, api: ApiInterface): PublisherPresenter =
        PublisherPresenter(mView, api)
}