package com.junemon.daggerin.feature.detail.game.view

import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import javax.inject.Inject

class GameDetailPresenter @Inject constructor(
    private val view: GameDetailView,
    private val api: ApiInterface,
    retrofitHelper: RetrofitHelper
) : RetrofitHelper by retrofitHelper {

    suspend fun getData(id: Int) {
        require(id != 0) {
            "id passed from main is 0"
        }
        try {
            view.setDialogShow(false)
            val data = api.getDetailGames(id).doOneShot()
            view.observeData(data)
            view.setDialogShow(true)

        } catch (e: Exception) {
            view.observeFailed(e)
            view.setDialogShow(true)
        }
    }
}