package com.junemon.daggerinyourface.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.junemon.daggerinyourface.presentation.model.GamePresentation
import com.junemon.daggerinyourface.presentation.model.PublisherPresentation

inline val Context.layoutInflater: android.view.LayoutInflater
    get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as android.view.LayoutInflater

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
}


