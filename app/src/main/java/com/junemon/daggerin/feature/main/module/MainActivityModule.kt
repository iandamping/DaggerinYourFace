package com.junemon.daggerin.feature.main.module

import com.junemon.daggerin.di.qualifier.MainApplicationCoroutineScope
import com.junemon.daggerin.feature.main.view.MainPresenter
import com.junemon.daggerin.feature.main.view.MainView
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.GameDaoHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

@Module
object MainActivityModule {

    @Provides
    fun provideMainPresenter(
        mainView: MainView, @MainApplicationCoroutineScope applicationScope: CoroutineScope,
        api: ApiInterface, retrofitHelper: RetrofitHelper, gameDaoHelper: GameDaoHelper
    ):MainPresenter = MainPresenter(mainView, applicationScope, api, retrofitHelper, gameDaoHelper)
}
