package com.junemon.daggerin.feature.main.view

import com.junemon.daggerin.base.BasePresenter
import com.junemon.daggerin.di.qualifier.MainApplicationCoroutineScope
import com.junemon.daggerin.model.GamesEntity
import com.junemon.daggerin.model.mapToDatabase
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.GameDaoHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenter @Inject constructor(
    view: MainView,
    @MainApplicationCoroutineScope private val customScope: CoroutineScope,
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper,
    private val gameDao: GameDaoHelper
) :
    BasePresenter<MainView>(view) {

    fun getData() {
        setDialogShow(false)
        customScope.launch {
            try {
                with(retrofitHelper) {
                    val data = api.getGames().doOneShot().data
                    check(data.isNotEmpty()) {
                        " empty data from service"
                    }
                    saveData(data)
                    consumeData()
                }
            } catch (e: Exception) {
                setDialogShow(true)
                view().observeFailed(e)
            }
        }

    }

    private suspend fun saveData(data: List<GamesEntity>) {
        gameDao.insertGame(*data.mapToDatabase().toTypedArray())
    }

    private suspend fun consumeData() {
        gameDao.loadGame().collect {
            view().observeData(it)
            setDialogShow(true)
        }

    }
}