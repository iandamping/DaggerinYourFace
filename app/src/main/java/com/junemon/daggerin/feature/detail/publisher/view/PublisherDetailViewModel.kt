package com.junemon.daggerin.feature.detail.publisher.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.junemon.daggerin.base.BaseViewModel
import com.junemon.daggerin.base.ResultRemoteToConsume
import com.junemon.daggerin.model.publisher.PublisherDetailEntity
import com.junemon.daggerin.network.ApiInterface
import com.junemon.daggerin.util.interfaces.RetrofitHelper
import javax.inject.Inject

class PublisherDetailViewModel @Inject constructor(
    private val api: ApiInterface,
    private val retrofitHelper: RetrofitHelper
) : BaseViewModel() {

    fun getData(id: Int): LiveData<ResultRemoteToConsume<PublisherDetailEntity>> {
        return liveData {
            try {
                emit(ResultRemoteToConsume.loading())
                require(id != 0) {
                    "id passed from main is 0"
                }
                retrofitHelper.run {
                    val data = api.getDetailPublisher(id).doOneShot()
                    checkNotNull(data)
                    emit(ResultRemoteToConsume.success(data))
                }
            } catch (e: Exception) {
                emit(ResultRemoteToConsume.error(e.message!!))
            }
        }
    }
}
