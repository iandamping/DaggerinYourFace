package com.junemon.daggerin.feature.detail.game.view

import com.junemon.daggerin.base.BasePresenter
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import kotlinx.coroutines.launch
import javax.inject.Inject

class GameDetailPresenter @Inject constructor(
    view: GameDetailView,
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper
) : BasePresenter<GameDetailView>(view) {

    fun getData(id:Int){
        customScope.launch {
            require(id !=0){
                "id passed from main is 0"
            }
            try {
                setDialogShow(false)
                retrofitHelper.run {
                    val data = api.getDetailGames(id).doOneShot()
                    view().observeData(data)
                    setDialogShow(true)
                }
            } catch (e:Exception){
                timberLogE(e.message)
            }
        }
    }
}