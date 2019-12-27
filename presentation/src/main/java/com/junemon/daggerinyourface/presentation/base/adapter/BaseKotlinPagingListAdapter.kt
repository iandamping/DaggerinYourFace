package com.junemon.daggerinyourface.presentation.base.adapter

import android.view.View
import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil

/**
 *
Created by Ian Damping on 03/06/2019.
Github = https://github.com/iandamping
 */
class BaseKotlinPagingListAdapter<T>(
    data: PagedList<T>,
    layout: Int,
    private val bindHolder: View.(T) -> Unit,
    diffUtil: DiffUtil.ItemCallback<T>,
    private val itemClicks: T.() -> Unit
) : BaseListPagingAdapter<T>(data, layout, diffUtil, itemClicks) {

    override fun onBindViewHolder(holder: MyAbstractPagingViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.itemView.bindHolder(item)
            holder.itemView.setOnClickListener { itemClicks(item)
            }
        }
    }
}
