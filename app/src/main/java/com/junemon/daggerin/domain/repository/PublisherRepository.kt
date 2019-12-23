package com.junemon.daggerin.domain.repository

import androidx.lifecycle.LiveData
import com.junemon.daggerin.base.ResultRemoteToConsume
import com.junemon.daggerin.base.ResultToConsume
import com.junemon.daggerin.domain.model.PublishersData
import com.junemon.daggerin.domain.model.PublishersDetailData

interface PublisherRepository {

    fun getCache(): LiveData<ResultToConsume<List<PublishersData>>>

    fun getDetailRemote(publisherID: Int): LiveData<ResultRemoteToConsume<PublishersDetailData>>
}
