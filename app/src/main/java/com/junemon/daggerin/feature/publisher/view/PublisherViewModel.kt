package com.junemon.daggerin.feature.publisher.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.junemon.daggerin.base.BaseViewModel
import com.junemon.daggerin.base.ResultToConsume
import com.junemon.daggerin.db.publisher.PublisherDbEntity
import com.junemon.daggerin.model.publisher.PublishersEntity
import com.junemon.daggerin.model.publisher.mapToDatabase
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.PublisherDaoHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import javax.inject.Inject
import kotlinx.coroutines.flow.map

class PublisherViewModel @Inject constructor(
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper,
    private val publisherDaoHelper: PublisherDaoHelper
) : BaseViewModel() {

    fun getData(): LiveData<ResultToConsume<List<PublisherDbEntity>>> {
        return liveData(getJobErrorHandler()) {
            val disposables = emitSource(publisherDaoHelper.loadPublisher().map {
                ResultToConsume.Loading(it)
            }.asLiveData())

            retrofitHelper.run {
                try {
                    val data = api.getPublisher().doOneShot().data
                    disposables.dispose()
                    check(data.isNotEmpty()) {
                        " empty data from service"
                    }
                    saveData(data)
                    emitSource(publisherDaoHelper.loadPublisher().map { ResultToConsume.Success(it) }.asLiveData())
                } catch (e: Exception) {
                    emitSource(publisherDaoHelper.loadPublisher().map {
                        ResultToConsume.Error(e.message!!, it)
                    }.asLiveData())
                }
            }
        }
    }

    private suspend fun saveData(data: List<PublishersEntity>) {
        publisherDaoHelper.insertPublisher(*data.mapToDatabase().toTypedArray())
    }
}
