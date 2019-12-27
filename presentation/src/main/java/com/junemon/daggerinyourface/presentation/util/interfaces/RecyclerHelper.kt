package com.junemon.daggerinyourface.presentation.util.interfaces

import android.view.View
import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.junemon.daggerinyourface.presentation.base.adapter.BaseKotlinListAdapter
import com.junemon.daggerinyourface.presentation.base.adapter.BaseKotlinPagingListAdapter

interface RecyclerHelper {

    fun <T> RecyclerView.setUpVerticalListAdapter(
        items: List<T>?,
        diffUtil: DiffUtil.ItemCallback<T>,
        layoutResId: Int,
        bindHolder: View.(T) -> Unit,
        itemClick: T.() -> Unit = {},
        manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)
    ): BaseKotlinListAdapter<T>?

    fun <T> RecyclerView.setUpVerticalGridAdapter(
        items: List<T>?,
        diffUtil: DiffUtil.ItemCallback<T>,
        layoutResId: Int,
        gridSize: Int,
        bindHolder: View.(T) -> Unit,
        itemClick: T.() -> Unit = {},
        manager: RecyclerView.LayoutManager = GridLayoutManager(this.context, gridSize)
    ): BaseKotlinListAdapter<T>?

    fun <T> RecyclerView.setUpHorizontalListAdapter(
        items: List<T>?,
        diffUtil: DiffUtil.ItemCallback<T>,
        layoutResId: Int,
        bindHolder: View.(T) -> Unit,
        itemClick: T.() -> Unit = {},
        manager: RecyclerView.LayoutManager = LinearLayoutManager(
            this.context, LinearLayoutManager.HORIZONTAL,
            false
        )
    ): BaseKotlinListAdapter<T>?

    fun <T> RecyclerView.setUpPagingVertical(
        items: PagedList<T>?,
        layoutResId: Int,
        bindHolder: View.(T) -> Unit,
        diffUtil: DiffUtil.ItemCallback<T>,
        itemClick: T.() -> Unit = {},
        manager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)
    ): BaseKotlinPagingListAdapter<T>?
}
