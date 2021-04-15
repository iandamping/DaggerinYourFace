package com.junemon.daggerin.feature.main.view

import com.junemon.daggerin.model.game.GamesEntity
import com.junemon.daggerin.model.game.mapToDatabase
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.GameDaoHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val view: MainView,
    private val api: ApiInterface,
    private val gameDao: GameDaoHelper,
    retrofitHelper: RetrofitHelper
) : RetrofitHelper by retrofitHelper {

    suspend fun getData() {
        try {
            view.setDialogShow(false)
            val dbSource = gameDao.loadGame().first()
            if (dbSource.isEmpty()){
                val data = api.getGames().doOneShot().data
                check(data.isNotEmpty()) {
                    " empty data from service"
                }
                saveData(data)
                consumeData()
            } else{
                view.observeData(dbSource)
                view.setDialogShow(true)
            }

        } catch (e: Exception) {
            view.observeFailed(e)
            view.setDialogShow(true)
        }

    }

    private suspend fun saveData(data: List<GamesEntity>) {
        gameDao.insertGame(*data.mapToDatabase().toTypedArray())
    }

    private suspend fun consumeData() {
        gameDao.loadGame().collect {
            view.observeData(it)
            view.setDialogShow(true)
        }


    }
}