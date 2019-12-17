package com.junemon.daggerin.feature.publisher.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.junemon.daggerin.R
import com.junemon.daggerin.model.PublisherCallback
import com.junemon.daggerin.model.PublishersEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_publisher.view.*

class PublisherAdapter(private val clickListener: (PublishersEntity) -> Unit = {}) :
    ListAdapter<PublishersEntity, PublisherAdapter.PublisherViewHolder>(PublisherCallback.publisherDiffCallbacks) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublisherViewHolder {
        val inflaters =
            LayoutInflater.from(parent.context).inflate(R.layout.item_publisher, parent, false)
        return PublisherViewHolder(
            inflaters
        )
    }

    override fun onBindViewHolder(holder: PublisherViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindView(item, clickListener)
    }

    class PublisherViewHolder(override val containerView: View?) :
        RecyclerView.ViewHolder(containerView!!),
        LayoutContainer {
        fun bindView(data: PublishersEntity, clickListener: (PublishersEntity) -> Unit) {
            containerView?.apply {
                tvText.text = data.name
                 Glide.with(ivImages.context).load(data.imageBackground).into(ivImages)
            }
            itemView.setOnClickListener {
                clickListener(data)
            }
        }
    }
}