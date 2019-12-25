package com.junemon.daggerin.domain.repository

import androidx.lifecycle.LiveData
import com.junemon.daggerin.domain.model.PublishersData
import com.junemon.daggerin.domain.model.PublishersDetailData
import com.junemon.daggerin.domain.model.ResultRemoteToConsume
import com.junemon.daggerin.domain.model.ResultToConsume

interface PublisherRepository {

    fun getCache(): LiveData<ResultToConsume<List<PublishersData>>>

    fun getDetailRemote(publisherID: Int): LiveData<ResultRemoteToConsume<PublishersDetailData>>
}
