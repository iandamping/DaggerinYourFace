package com.junemon.daggerin.feature.publisher.view

import com.ian.app.helper.util.timberLogE
import com.junemon.daggerin.base.BasePresenter
import com.junemon.daggerin.network.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PublisherPresenter @Inject constructor(
    publisherView: PublisherView,
    private val api: ApiInterface
) : BasePresenter<PublisherView>(publisherView) {

    private val TAG = "PublisherPresenter"


    fun getData() {
        try {
            requireNotNull(api){
                "api interface is null or not initialized yet"
            }
            compositeDisposable.add(
                api.getPublisher().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
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