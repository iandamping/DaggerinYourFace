package com.junemon.daggerinyourface.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.junemon.daggerinyourface.model.domain.ResultRemoteToConsume
import com.junemon.daggerinyourface.model.domain.ResultToConsume
import com.junemon.daggerinyourface.model.domain.publisher.PublisherPagingData
import com.junemon.daggerinyourface.model.domain.publisher.PublishersData
import com.junemon.daggerinyourface.model.domain.publisher.PublishersDetailData

interface PublisherRepository {

    fun getCache(): LiveData<ResultToConsume<List<PublishersData>>>

    fun getDetailRemote(publisherID: Int): LiveData<ResultRemoteToConsume<PublishersDetailData>>

    fun getPaginationCache(): LiveData<PagedList<PublisherPagingData>>
}
