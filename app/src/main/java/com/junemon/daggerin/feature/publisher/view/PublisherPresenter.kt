package com.junemon.daggerin.feature.publisher.view

import com.junemon.daggerin.base.BasePresenter
import com.junemon.daggerin.model.publisher.PublishersEntity
import com.junemon.daggerin.model.publisher.mapToDatabase
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.PublisherDaoHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class PublisherPresenter @Inject constructor(
    publisherView: PublisherView,
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper,
    private val publisherDaoHelper: PublisherDaoHelper
) : BasePresenter<PublisherView>(publisherView) {

    fun getData() {
        setDialogShow(false)
        customScope.launch {
            try {
                retrofitHelper.run {
                    val data = api.getPublisher().doOneShot().data
                    check(data.isNotEmpty()) {
                        " empty data from service"
                    }
                    saveData(data)
                    consumeData()
                }
            } catch (e: Exception) {
                view().observeFailed(e)
            }
        }
    }

    private suspend fun saveData(data: List<PublishersEntity>) {
        publisherDaoHelper.insertPublisher(*data.mapToDatabase().toTypedArray())
    }

    private suspend fun consumeData() {
        publisherDaoHelper.loadPublisher().collect {
            view().observeData(it)
            setDialogShow(true)
        }

    }
}