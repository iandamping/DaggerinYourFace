package com.junemon.daggerinyourface.presentation.util.classes

import android.view.View
import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.junemon.daggerinyourface.presentation.base.adapter.BaseKotlinListAdapter
import com.junemon.daggerinyourface.presentation.base.adapter.BaseKotlinPagingListAdapter
import com.junemon.daggerinyourface.presentation.util.interfaces.RecyclerHelper
import javax.inject.Inject

class RecyclerHelperImpl @Inject constructor() :
    RecyclerHelper {
    override fun <T> RecyclerView.setUpVerticalListAdapter(
        items: List<T>?,
        diffUtil: DiffUtil.ItemCallback<T>,
        layoutResId: Int,
        bindHolder: View.(T) -> Unit,
        itemClick: T.() -> Unit,
        manager: RecyclerView.LayoutManager
    ): BaseKotlinListAdapter<T>? {
        requireNotNull(items) {
            " your list data is null"
        }

        return BaseKotlinListAdapter(
            layout = layoutResId,
            bindHolder = { bindHolder(it) },
            diffUtil = diffUtil,
            itemClicks = { itemClick() }).apply {
            layoutManager = manager
            adapter = this
            submitList(items)
            notifyDataSetChanged()
        }
    }

    override fun <T> RecyclerView.setUpVerticalGridAdapter(
        items: List<T>?,
        diffUtil: DiffUtil.ItemCallback<T>,
        layoutResId: Int,
        gridSize: Int,
        bindHolder: View.(T) -> Unit,
        itemClick: T.() -> Unit,
        manager: RecyclerView.LayoutManager
    ): BaseKotlinListAdapter<T>? {

        requireNotNull(items) {
            " your list data is null"
        }

        return BaseKotlinListAdapter(
            layout = layoutResId,
            bindHolder = { bindHolder(it) },
            diffUtil = diffUtil,
            itemClicks = { itemClick() }).apply {
            layoutManager = manager
            adapter = this
            submitList(items)
            notifyDataSetChanged()
        }
    }

    override fun <T> RecyclerView.setUpHorizontalListAdapter(
        items: List<T>?,
        diffUtil: DiffUtil.ItemCallback<T>,
        layoutResId: Int,
        bindHolder: View.(T) -> Unit,
        itemClick: T.() -> Unit,
        manager: RecyclerView.LayoutManager
    ): BaseKotlinListAdapter<T>? {
        if (this.onFlingListener == null) {
            RecyclerHorizontalSnapHelper()
                .attachToRecyclerView(this)
        }

        requireNotNull(items) {
            " your list data is null"
        }
        return BaseKotlinListAdapter(
            layout = layoutResId,
            bindHolder = { bindHolder(it) },
            diffUtil = diffUtil,
            itemClicks = { itemClick() }).apply {
            layoutManager = manager
            adapter = this
            submitList(items)
            notifyDataSetChanged()
        }
    }

    override fun <T> RecyclerView.setUpPagingVertical(
        items: PagedList<T>?,
        layoutResId: Int,
        bindHolder: View.(T) -> Unit,
        diffUtil: DiffUtil.ItemCallback<T>,
        itemClick: T.() -> Unit,
        manager: RecyclerView.LayoutManager
    ): BaseKotlinPagingListAdapter<T>? {
        requireNotNull(items) {
            " your list data is null"
        }
        return BaseKotlinPagingListAdapter(
            data = items,
            layout = layoutResId,
            bindHolder = { bindHolder(it) },
            diffUtil = diffUtil,
            itemClicks = {
                itemClick()
            }).apply {
            layoutManager = manager
            adapter = this
            submitList(items)
            notifyDataSetChanged()
        }
    }
}
