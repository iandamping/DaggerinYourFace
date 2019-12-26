package com.junemon.daggerinyourface.domain.repository

import androidx.lifecycle.LiveData
import com.junemon.daggerinyourface.domain.model.PublishersData
import com.junemon.daggerinyourface.domain.model.PublishersDetailData
import com.junemon.daggerinyourface.domain.model.ResultRemoteToConsume
import com.junemon.daggerinyourface.domain.model.ResultToConsume

interface PublisherRepository {

    fun getCache(): LiveData<ResultToConsume<List<PublishersData>>>

    fun getDetailRemote(publisherID: Int): LiveData<ResultRemoteToConsume<PublishersDetailData>>
}
