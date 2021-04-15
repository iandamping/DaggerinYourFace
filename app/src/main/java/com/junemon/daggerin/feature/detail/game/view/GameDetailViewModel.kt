package com.junemon.daggerin.feature.detail.game.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.junemon.daggerin.model.game.GamesDetailEntity
import com.junemon.daggerin.model.state.Results
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import javax.inject.Inject

class GameDetailViewModel @Inject constructor(
    private val api: ApiInterface,
    retrofitHelper: RetrofitHelper
) : RetrofitHelper by retrofitHelper, ViewModel() {

    fun getData(id: Int): LiveData<Results<GamesDetailEntity>> {
        return liveData {
            try {
                emit(Results.Loading)
                require(id != 0) {
                    "id passed from main is 0"
                }
                val data = api.getDetailGames(id).doOneShot()
                emit(Results.Success(data))
            } catch (e: Exception) {
                emit(Results.Error(e.message!!))
            }
        }
    }
}
