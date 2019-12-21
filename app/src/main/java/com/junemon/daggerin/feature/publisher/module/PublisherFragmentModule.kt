package com.junemon.daggerin.feature.publisher.module

import com.junemon.daggerin.feature.publisher.view.PublisherPresenter
import com.junemon.daggerin.feature.publisher.view.PublisherView
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.PublisherDaoHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import dagger.Module
import dagger.Provides

@Module
class PublisherFragmentModule() {

    @Provides
    fun providePublisherPresenter(
        mView: PublisherView,
        api: ApiInterface,
        retrofitHelper: RetrofitHelper,
        publisherDaoHelper: PublisherDaoHelper
    ): PublisherPresenter =
        PublisherPresenter(mView, api, retrofitHelper, publisherDaoHelper)
}