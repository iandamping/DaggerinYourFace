package com.junemon.daggerin.feature.detail.publisher.view

import com.junemon.daggerin.model.publisher.PublisherDetailEntity


interface PublisherDetailView {
    fun observeData(data: PublisherDetailEntity)
    fun observeFailed(throws: Throwable)
}