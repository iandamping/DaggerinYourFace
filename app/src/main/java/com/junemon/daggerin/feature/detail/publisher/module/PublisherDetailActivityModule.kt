package com.junemon.daggerin.feature.detail.publisher.module

import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailPresenter
import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailView
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import dagger.Module
import dagger.Provides

@Module
class PublisherDetailActivityModule {

    @Provides
    fun providePublisherDetailPresenter(view: PublisherDetailView, apiInterface: ApiInterface, retrofitHelper: RetrofitHelper): PublisherDetailPresenter {
        return PublisherDetailPresenter(
            view = view,
            api = apiInterface,
            retrofitHelper = retrofitHelper
        )
    }
}