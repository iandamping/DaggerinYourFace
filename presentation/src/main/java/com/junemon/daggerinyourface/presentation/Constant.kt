package com.junemon.daggerinyourface.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.junemon.daggerinyourface.model.domain.game.GamePagingData
import com.junemon.daggerinyourface.model.domain.publisher.PublisherPagingData
import com.junemon.daggerinyourface.model.presentation.game.GamePresentation
import com.junemon.daggerinyourface.model.presentation.publisher.PublisherPresentation

inline val Context.layoutInflater: LayoutInflater
    get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

internal fun ViewGroup.inflates(layout: Int): View {
    return LayoutInflater.from(context).inflate(layout, this, false)
}

object Constant {

    val gamesDiffCallbacks = object : DiffUtil.ItemCallback<GamePresentation>() {
        override fun areItemsTheSame(
            oldItem: GamePresentation,
            newItem: GamePresentation
        ): Boolean =
            oldItem.gameName == newItem.gameName

        override fun areContentsTheSame(
            oldItem: GamePresentation,
            newItem: GamePresentation
        ): Boolean =
            oldItem == newItem
    }

    val gamesPagingDiffCallbacks = object : DiffUtil.ItemCallback<GamePagingData>() {
        override fun areItemsTheSame(
            oldItem: GamePagingData,
            newItem: GamePagingData
        ): Boolean =
            oldItem.gameName == newItem.gameName

        override fun areContentsTheSame(
            oldItem: GamePagingData,
            newItem: GamePagingData
        ): Boolean =
            oldItem == newItem
    }

    val publisherDiffCallbacks = object : DiffUtil.ItemCallback<PublisherPresentation>() {
        override fun areItemsTheSame(
            oldItem: PublisherPresentation,
            newItem: PublisherPresentation
        ): Boolean =
            oldItem.publisherName == newItem.publisherName

        override fun areContentsTheSame(
            oldItem: PublisherPresentation,
            newItem: PublisherPresentation
        ): Boolean =
            oldItem == newItem
    }

    val publisherPagingDiffCallbacks = object : DiffUtil.ItemCallback<PublisherPagingData>() {
        override fun areItemsTheSame(
            oldItem: PublisherPagingData,
            newItem: PublisherPagingData
        ): Boolean =
            oldItem.publisherName == newItem.publisherName

        override fun areContentsTheSame(
            oldItem: PublisherPagingData,
            newItem: PublisherPagingData
        ): Boolean =
            oldItem == newItem
    }
}
