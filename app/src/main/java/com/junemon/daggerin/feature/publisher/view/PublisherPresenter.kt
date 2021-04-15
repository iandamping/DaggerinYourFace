package com.junemon.daggerin.feature.publisher.view

import com.junemon.daggerin.model.publisher.PublishersEntity
import com.junemon.daggerin.model.publisher.mapToDatabase
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.PublisherDaoHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class PublisherPresenter @Inject constructor(
    private val publisherView: PublisherView,
    private val api: ApiInterface,
    retrofitHelper: RetrofitHelper,
    private val publisherDaoHelper: PublisherDaoHelper
) : RetrofitHelper by retrofitHelper {

    suspend fun getData() {
        try {
            publisherView.setDialogShow(false)
            val dbSource = publisherDaoHelper.loadPublisher().first()
            if (dbSource.isEmpty()){
                val data = api.getPublisher().doOneShot().data
                check(data.isNotEmpty()) {
                    " empty data from service"
                }
                saveData(data)
                consumeData()
            } else{
                publisherView.observeData(dbSource)
                publisherView.setDialogShow(true)
            }
        } catch (e: Exception) {
            publisherView.observeFailed(e)
            publisherView.setDialogShow(true)
        }
    }

    private suspend fun saveData(data: List<PublishersEntity>) {
        publisherDaoHelper.insertPublisher(*data.mapToDatabase().toTypedArray())
    }

    private suspend fun consumeData() {
        publisherDaoHelper.loadPublisher().collect {
            publisherView.observeData(it)
            publisherView.setDialogShow(true)
        }


    }
}