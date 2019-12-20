package com.junemon.daggerin.feature.detail.publisher.view

import com.junemon.daggerin.base.BasePresenter
import com.junemon.daggerin.feature.detail.game.view.GameDetailView
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import kotlinx.coroutines.launch
import javax.inject.Inject

class PublisherDetailPresenter @Inject constructor(
    view: PublisherDetailView,
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper
):BasePresenter<PublisherDetailView>(view) {

    fun getData(id:Int){
        customScope.launch {
            require(id !=0){
                "id passed from main is 0"
            }
            try {
                setDialogShow(false)
                retrofitHelper.run {
                    val data = api.getDetailPublisher(id).doOneShot()
                    view().observeData(data)
                    setDialogShow(true)
                }
            } catch (e:Exception){
                timberLogE(e.message)
            }
        }
    }
}