package com.junemon.daggerin.domain.usecase

import androidx.lifecycle.LiveData
import com.junemon.daggerin.base.ResultRemoteToConsume
import com.junemon.daggerin.base.ResultToConsume
import com.junemon.daggerin.domain.model.PublishersData
import com.junemon.daggerin.domain.model.PublishersDetailData
import com.junemon.daggerin.domain.repository.PublisherRepository
import javax.inject.Inject

class PublisherUseCase @Inject constructor(private val repository: PublisherRepository) {

    fun getCache(): LiveData<ResultToConsume<List<PublishersData>>> = repository.getCache()

    fun getDetailRemote(publisherID: Int): LiveData<ResultRemoteToConsume<PublishersDetailData>> =
        repository.getDetailRemote(publisherID)
}
