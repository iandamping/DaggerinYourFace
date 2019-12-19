package com.junemon.daggerin.feature.main.module

import com.junemon.daggerin.feature.main.view.MainPresenter
import com.junemon.daggerin.feature.main.view.MainView
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule() {

    @Provides
    fun provideMainPresenter(mainView: MainView, api:ApiInterface,retrofitHelper: RetrofitHelper) =
        MainPresenter(mainView, api,retrofitHelper)
}
