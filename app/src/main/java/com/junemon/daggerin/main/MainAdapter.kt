package com.junemon.daggerin.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.junemon.daggerin.R
import com.junemon.daggerin.model.GameCallback
import com.junemon.daggerin.model.GamesEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_games.view.*

class MainAdapter(
    private val clickListener: (GamesEntity) -> Unit = {}
) : ListAdapter<GamesEntity, MainAdapter.MainViewHolder>(GameCallback.gamesDiffCallbacks) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflaters =
            LayoutInflater.from(parent.context).inflate(R.layout.item_games, parent, false)
        return MainViewHolder(inflaters)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindView(item, clickListener)
    }

    class MainViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(containerView!!), LayoutContainer {
        fun bindView(data: GamesEntity, clickListener: (GamesEntity) -> Unit) {
            containerView?.apply {
                tvText.text = data.name
                Glide.with(ivImages.context).load(data.backgroundImage).into(ivImages)
            }
            itemView.setOnClickListener {
                clickListener(data)
            }
        }
    }


}