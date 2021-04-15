package com.junemon.daggerin.feature.publisher.view

import com.junemon.daggerin.base.adapter.BaseView
import com.junemon.daggerin.db.publisher.PublisherDbEntity

interface PublisherView:BaseView {
    fun observeData(data: List<PublisherDbEntity>)
    fun observeFailed(throws: Throwable)
}