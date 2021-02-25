package com.junemon.daggerin.feature.publisher.module

import com.junemon.daggerin.di.qualifier.MainApplicationCoroutineScope
import com.junemon.daggerin.feature.publisher.view.PublisherPresenter
import com.junemon.daggerin.feature.publisher.view.PublisherView
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

@Module
object PublisherActivityModule {

    @Provides
    fun providePublisherPresenter(
        mView: PublisherView,
        @MainApplicationCoroutineScope applicationScope: CoroutineScope,
        api: ApiInterface,
        retrofitHelper: RetrofitHelper
    ): PublisherPresenter = PublisherPresenter(mView, applicationScope, api, retrofitHelper)
}