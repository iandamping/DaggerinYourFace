package com.junemon.daggerinyourface.domain.usecase

import androidx.lifecycle.LiveData
import com.junemon.daggerinyourface.domain.model.PublishersData
import com.junemon.daggerinyourface.domain.model.PublishersDetailData
import com.junemon.daggerinyourface.domain.model.ResultRemoteToConsume
import com.junemon.daggerinyourface.domain.model.ResultToConsume
import com.junemon.daggerinyourface.domain.repository.PublisherRepository
import javax.inject.Inject

class PublisherUseCase @Inject constructor(private val repository: PublisherRepository) {

    fun getCache(): LiveData<ResultToConsume<List<PublishersData>>> = repository.getCache()

    fun getDetailRemote(publisherID: Int): LiveData<ResultRemoteToConsume<PublishersDetailData>> =
        repository.getDetailRemote(publisherID)
}
