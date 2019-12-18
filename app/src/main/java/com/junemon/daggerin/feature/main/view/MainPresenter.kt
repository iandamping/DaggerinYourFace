package com.junemon.daggerin.feature.main.view

import com.junemon.daggerin.MainApplication.appComponent.retrofitHelper
import com.junemon.daggerin.base.BasePresenter
import com.junemon.daggerin.network.ApiInterface
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenter @Inject constructor(view: MainView, private val api: ApiInterface) :
    BasePresenter<MainView>(view) {

    fun getData() {
        setDialogShow(false)
        customScope.launch {
                try {
                    retrofitHelper.run {
                        val data = api.getGames().doOneShot().data
                        check(data.isNotEmpty()){
                            " empty data from service"
                        }
                        setDialogShow(true)
                        view().observeData(data)
                    }
                }catch (e:Exception){
                    setDialogShow(true)
                    view().observeFailed(e)
                }
            }

    }
}