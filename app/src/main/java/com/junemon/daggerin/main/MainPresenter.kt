package com.junemon.daggerin.main

import com.ian.app.helper.util.timberLogE
import com.junemon.daggerin.base.BasePresenter
import com.junemon.daggerin.network.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(view: MainView,private val api:ApiInterface) : BasePresenter<MainView>(view) {
    private val TAG = "MainPresenter"
    
    fun getData() {
        try {
            requireNotNull(api){
                "api interface is null or not initialized yet"
            }
            compositeDisposable.add(
                api.getGames().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {
                        setDialogShow(false)
                    }
                    .subscribe({
                        setDialogShow(true)
                        view().observeData(it.data)
                    }, {
                        setDialogShow(true)
                        view().observeFailed(it)
                    })
            )
        }catch (e:Exception){
            timberLogE(e.message)
        }
    }
}