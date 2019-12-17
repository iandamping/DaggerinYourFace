package com.junemon.daggerin.di.module

import com.junemon.daggerin.di.module.NetworkModule.Companion.provideRetrofit
import com.junemon.daggerin.main.MainPresenter
import com.junemon.daggerin.main.MainView
import com.junemon.daggerin.network.ApiInterface
import dagger.Module
import dagger.Provides

@Module
class MainPresenterModule(private val mainView: MainView) {

    @Provides
    fun provideMainView(): MainView = mainView

    @Provides
    fun provideMainPresenter(mainView: MainView,api:ApiInterface) = MainPresenter(mainView,api)
}
