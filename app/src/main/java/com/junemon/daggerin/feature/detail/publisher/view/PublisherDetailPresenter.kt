package com.junemon.daggerin.feature.detail.publisher.view

import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import javax.inject.Inject

class PublisherDetailPresenter @Inject constructor(
    private val view: PublisherDetailView,
    private val api: ApiInterface,
    retrofitHelper: RetrofitHelper
) : RetrofitHelper by retrofitHelper {

    suspend fun getData(id: Int) {
        require(id != 0) {
            "id passed from main is 0"
        }
        try {
            view.setDialogShow(false)
            val data = api.getDetailPublisher(id).doOneShot()
            view.observeData(data)
            view.setDialogShow(true)
        } catch (e: Exception) {
            view.observeFailed(e)
            view.setDialogShow(true)
        }
    }
}