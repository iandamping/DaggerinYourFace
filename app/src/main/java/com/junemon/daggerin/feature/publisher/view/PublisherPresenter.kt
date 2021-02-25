package com.junemon.daggerin.feature.publisher.view

import com.junemon.daggerin.base.BasePresenter
import com.junemon.daggerin.di.qualifier.MainApplicationCoroutineScope
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class PublisherPresenter @Inject constructor(
    publisherView: PublisherView,
    @MainApplicationCoroutineScope private val customScope: CoroutineScope,
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper
) : BasePresenter<PublisherView>(publisherView) {

    fun getData() {
        setDialogShow(false)
        customScope.launch {
            try {
                with(retrofitHelper) {
                    val data = api.getPublisher().doOneShot().data
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