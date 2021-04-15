package com.junemon.daggerin.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

inline val Context.layoutInflater: LayoutInflater
    get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

fun ViewGroup.inflates(layout: Int): View {
    return LayoutInflater.from(context).inflate(layout, this, false)
}

object Constant {
    const val intentGamesDetailKey: String = "intent games detail"
    const val intentPublisherDetailKey: String = "intent gamepublishers detail"
}
