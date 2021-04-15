package com.junemon.daggerin.feature.publisher.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.junemon.daggerin.db.publisher.PublisherDbEntity
import com.junemon.daggerin.model.publisher.PublishersEntity
import com.junemon.daggerin.model.publisher.mapToDatabase
import com.junemon.daggerin.model.state.Results
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.PublisherDaoHelper
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class PublisherViewModel @Inject constructor(
    private val api: ApiInterface,
    retrofitHelper: RetrofitHelper,
    private val publisherDaoHelper: PublisherDaoHelper
) : RetrofitHelper by retrofitHelper, ViewModel() {

    fun getData(): LiveData<Results<List<PublisherDbEntity>>> {
        return flow<Results<List<PublisherDbEntity>>> {
            val dbSource = publisherDaoHelper.loadPublisher().first()
            if (dbSource.isEmpty()) {
                val data = api.getPublisher().doOneShot().data
                check(data.isNotEmpty()) {
                    " empty data from service"
                }
                saveData(data)
                emitAll(publisherDaoHelper.loadPublisher().map {
                    Results.Success(it)
                })
            } else {
                emit(Results.Success(dbSource))
            }
        }.catch { emit(Results.Error(it.localizedMessage ?: "b")) }
            .onStart { emit(Results.Loading) }
            .asLiveData()
    }

    private suspend fun saveData(data: List<PublishersEntity>) {
        publisherDaoHelper.insertPublisher(*data.mapToDatabase().toTypedArray())
    }
}
