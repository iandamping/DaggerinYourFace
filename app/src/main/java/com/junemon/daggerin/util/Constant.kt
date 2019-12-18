package com.junemon.daggerin.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

inline val Context.layoutInflater: android.view.LayoutInflater
    get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as android.view.LayoutInflater

internal fun ViewGroup.inflates(layout: Int): View {
    return LayoutInflater.from(context).inflate(layout, this, false)
}