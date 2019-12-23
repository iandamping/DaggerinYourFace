package com.junemon.daggerin.feature.game.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.junemon.daggerin.base.BaseViewModel
import com.junemon.daggerin.base.ResultToConsume
import com.junemon.daggerin.db.game.GameDbEntity
import com.junemon.daggerin.model.game.GamesEntity
import com.junemon.daggerin.model.game.mapToDatabase
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.GameDaoHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import javax.inject.Inject
import kotlinx.coroutines.flow.map

class GameViewModel @Inject constructor(
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper,
    private val gameDao: GameDaoHelper
) :
    BaseViewModel() {

    fun getData(): LiveData<ResultToConsume<List<GameDbEntity>>> {
        return liveData(getJobErrorHandler()) {
            val disposables = emitSource(gameDao.loadGame().map {
                ResultToConsume.Loading(it)
            }.asLiveData())

            retrofitHelper.run {
                try {
                    val data = api.getGames().doOneShot().data
                    disposables.dispose()
                    check(data.isNotEmpty()) {
                        " empty data from service"
                    }
                    saveData(data)
                    emitSource(gameDao.loadGame().map { ResultToConsume.Success(it) }.asLiveData())
                } catch (e: Exception) {
                    emitSource(gameDao.loadGame().map {
                        ResultToConsume.Error(e.message!!, it)
                    }.asLiveData())
                }
            }
        }
    }

    private suspend fun saveData(data: List<GamesEntity>) {
        gameDao.insertGame(*data.mapToDatabase().toTypedArray())
    }
}
