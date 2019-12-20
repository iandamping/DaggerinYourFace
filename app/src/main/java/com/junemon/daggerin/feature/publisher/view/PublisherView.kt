package com.junemon.daggerin.feature.publisher.view

import com.junemon.daggerin.db.publisher.PublisherDbEntity

interface PublisherView {
    fun observeData(data: List<PublisherDbEntity>)
    fun observeFailed(throws: Throwable)
}