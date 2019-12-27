package com.junemon.daggerinyourface.presentation.vm

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.junemon.daggerinyourface.base.BaseViewModel
import com.junemon.daggerinyourface.domain.model.*
import com.junemon.daggerinyourface.domain.usecase.PublisherUseCase
import javax.inject.Inject

class PublisherPresentationViewModel @Inject constructor(private val repository: PublisherUseCase) :
    BaseViewModel() {

    fun getCache(): LiveData<ResultToConsume<List<PublishersData>>> = repository.getCache()

    fun getDetailRemote(publisherID: Int): LiveData<ResultRemoteToConsume<PublishersDetailData>> =
        repository.getDetailRemote(publisherID)

    fun getPaginationCache(): LiveData<PagedList<PublisherPagingData>> = repository.getPaginationCache()
}
