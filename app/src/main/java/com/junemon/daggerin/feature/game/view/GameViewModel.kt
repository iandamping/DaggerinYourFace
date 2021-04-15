package com.junemon.daggerin.feature.game.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.junemon.daggerin.db.game.GameDbEntity
import com.junemon.daggerin.model.game.GamesEntity
import com.junemon.daggerin.model.game.mapToDatabase
import com.junemon.daggerin.model.state.Results
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.GameDaoHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GameViewModel @Inject constructor(
    private val api: ApiInterface,
    retrofitHelper: RetrofitHelper,
    private val gameDao: GameDaoHelper
) : RetrofitHelper by retrofitHelper,
    ViewModel() {

    fun getData(): LiveData<Results<List<GameDbEntity>>> {
        return flow<Results<List<GameDbEntity>>> {
            val dbSource = gameDao.loadGame().first()
            if (dbSource.isEmpty()) {
                val data = api.getGames().doOneShot().data
                check(data.isNotEmpty()) {
                    " empty data from service"
                }
                saveData(data)
                emitAll(gameDao.loadGame().map {
                    Results.Success(it)
                })
            }else{
                emit(Results.Success(dbSource))
            }
        }.catch { emit(Results.Error(it.localizedMessage ?: "b")) }
            .onStart { emit(Results.Loading) }
            .asLiveData()
    }

    private suspend fun saveData(data: List<GamesEntity>) {
        gameDao.insertGame(*data.mapToDatabase().toTypedArray())
    }
}
