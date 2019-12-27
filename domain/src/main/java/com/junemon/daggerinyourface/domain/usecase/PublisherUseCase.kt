package com.junemon.daggerinyourface.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.junemon.daggerinyourface.domain.model.*
import com.junemon.daggerinyourface.domain.repository.PublisherRepository
import javax.inject.Inject

class PublisherUseCase @Inject constructor(private val repository: PublisherRepository) {

    fun getCache(): LiveData<ResultToConsume<List<PublishersData>>> = repository.getCache()

    fun getDetailRemote(publisherID: Int): LiveData<ResultRemoteToConsume<PublishersDetailData>> =
        repository.getDetailRemote(publisherID)

    fun getPaginationCache(): LiveData<PagedList<PublisherPagingData>> = repository.getPaginationCache()
}
