package com.junemon.daggerinyourface.presentation.base.adapter

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.junemon.daggerinyourface.presentation.inflates
import kotlinx.android.extensions.LayoutContainer

abstract class BaseListPagingAdapter<T>(
    protected var data: PagedList<T>,
    private val layout: Int,
    diffUtil: DiffUtil.ItemCallback<T>,
    private val clickListener: (T) -> Unit
) : PagedListAdapter<T, BaseListPagingAdapter.MyAbstractPagingViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAbstractPagingViewHolder {
        return MyAbstractPagingViewHolder(parent.inflates(layout))
    }

    override fun onBindViewHolder(holder: MyAbstractPagingViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.itemView.bind(item)
            holder.itemView.setOnClickListener {
                clickListener(item)
            }
        }
    }

    protected open fun View.bind(item: T) {
    }

    class MyAbstractPagingViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer
}
