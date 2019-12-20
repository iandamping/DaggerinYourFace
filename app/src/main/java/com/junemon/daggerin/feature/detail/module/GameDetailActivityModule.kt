package com.junemon.daggerin.feature.detail.module

import com.junemon.daggerin.feature.detail.GameDetailPresenter
import com.junemon.daggerin.feature.detail.GameDetailView
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import dagger.Module
import dagger.Provides

@Module
class GameDetailActivityModule {

    @Provides
    fun provideGameDetailPresenter(view: GameDetailView,apiInterface: ApiInterface,retrofitHelper: RetrofitHelper):GameDetailPresenter{
        return GameDetailPresenter(view = view,api = apiInterface,retrofitHelper = retrofitHelper)
    }
}