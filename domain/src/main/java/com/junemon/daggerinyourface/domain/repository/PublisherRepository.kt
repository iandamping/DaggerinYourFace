package com.junemon.daggerinyourface.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.junemon.daggerinyourface.domain.model.*

interface PublisherRepository {

    fun getCache(): LiveData<ResultToConsume<List<PublishersData>>>

    fun getDetailRemote(publisherID: Int): LiveData<ResultRemoteToConsume<PublishersDetailData>>

    fun getPaginationCache(): LiveData<PagedList<PublisherPagingData>>
}
