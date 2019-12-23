package com.junemon.daggerin.presentation.vm

import androidx.lifecycle.LiveData
import com.junemon.daggerin.base.BaseViewModel
import com.junemon.daggerin.base.ResultRemoteToConsume
import com.junemon.daggerin.base.ResultToConsume
import com.junemon.daggerin.domain.model.PublishersData
import com.junemon.daggerin.domain.model.PublishersDetailData
import com.junemon.daggerin.domain.usecase.PublisherUseCase
import javax.inject.Inject

class PublisherPresentationViewModel @Inject constructor(private val repository: PublisherUseCase) :
    BaseViewModel() {

    fun getCache(): LiveData<ResultToConsume<List<PublishersData>>> = repository.getCache()

    fun getDetailRemote(publisherID: Int): LiveData<ResultRemoteToConsume<PublishersDetailData>> =
        repository.getDetailRemote(publisherID)
}
