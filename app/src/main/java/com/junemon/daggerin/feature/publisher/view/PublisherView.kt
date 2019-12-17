package com.junemon.daggerin.feature.publisher.view

import com.junemon.daggerin.model.PublishersEntity

interface PublisherView {
    fun observeData(data:List<PublishersEntity>)
    fun observeFailed(throws:Throwable)
}