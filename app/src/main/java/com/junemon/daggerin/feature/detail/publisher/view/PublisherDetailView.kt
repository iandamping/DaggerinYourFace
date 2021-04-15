package com.junemon.daggerin.feature.detail.publisher.view

import com.junemon.daggerin.base.adapter.BaseView
import com.junemon.daggerin.model.publisher.PublisherDetailEntity


interface PublisherDetailView:BaseView {
    fun observeData(data: PublisherDetailEntity)
    fun observeFailed(throws: Throwable)
}