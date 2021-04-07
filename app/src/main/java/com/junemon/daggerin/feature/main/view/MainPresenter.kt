package com.junemon.daggerin.feature.main.view

import com.junemon.daggerin.base.BasePresenter
import com.junemon.daggerin.db.game.GameDbEntity
import com.junemon.daggerin.di.qualifier.MainApplicationCoroutineScope
import com.junemon.daggerin.feature.main.model.MainActivityViewModel
import com.junemon.daggerin.model.GamesEntity
import com.junemon.daggerin.model.mapToDatabase
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.GameDaoHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenter @Inject constructor(
    view: MainView,
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper,
    private val gameDao: GameDaoHelper
) :
    BasePresenter<MainView>(view) {

    fun fetchData(): Flow<MainActivityViewModel<List<GameDbEntity>>> = flow {
        try {
            with(retrofitHelper) {
                val data = api.getGames().doOneShot().data
                if (data.isNullOrEmpty()) {
                    emit(MainActivityViewModel.EmptyItem)
                } else {
                    saveData(data)
                    emit(MainActivityViewModel.Result(getCacheData()))
                }
            }
        } catch (e: Exception) {
            emit(MainActivityViewModel.Error(e.message ?: "error"))
        } finally {
            emit(MainActivityViewModel.Complete)
        }
    }.onStart { emit(MainActivityViewModel.Loading) }


    private suspend fun saveData(data: List<GamesEntity>) {
        gameDao.insertGame(*data.mapToDatabase().toTypedArray())
    }

    private suspend fun getCacheData() = gameDao.loadGame().first()

}