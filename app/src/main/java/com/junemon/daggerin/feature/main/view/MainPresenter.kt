package com.junemon.daggerin.feature.main.view

import com.junemon.daggerin.base.BasePresenter
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenter @Inject constructor(
    view: MainView,
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper
) :
    BasePresenter<MainView>(view) {

    fun getData() {
        setDialogShow(false)
        customScope.launch {
            try {
                retrofitHelper.run {
                    val data = api.getGames().doOneShot().data
                    check(data.isNotEmpty()) {
                        " empty data from service"
                    }
                    setDialogShow(true)
                    view().observeData(data)
                }
            } catch (e: Exception) {
                setDialogShow(true)
                view().observeFailed(e)
            }
        }

    }
}