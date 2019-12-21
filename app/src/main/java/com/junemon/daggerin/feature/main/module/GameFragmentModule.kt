package com.junemon.daggerin.feature.main.module

import com.junemon.daggerin.feature.main.view.GamePresenter
import com.junemon.daggerin.feature.main.view.GameView
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.GameDaoHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import dagger.Module
import dagger.Provides

@Module
class GameFragmentModule() {

    @Provides
    fun provideMainPresenter(
        gameView: GameView,
        api: ApiInterface,
        retrofitHelper: RetrofitHelper,
        gameDaoHelper: GameDaoHelper
    ) =
        GamePresenter(gameView, api, retrofitHelper, gameDaoHelper)
}
