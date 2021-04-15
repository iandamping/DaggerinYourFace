package com.junemon.daggerin.util.classes

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.junemon.daggerin.R
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import javax.inject.Inject

class LoadImageHelperImpl @Inject constructor(
    private val requestOptions: RequestOptions,
    private val requestManager: RequestManager
) : LoadImageHelper {

    override fun ImageView.loadWithGlideSmall(url: String?) {
        requestManager.load(url).apply(requestOptions.override(150, 150))
            .thumbnail(0.25f)
            .into(this)
    }

    override fun ImageView.loadWithGlideCustomSize(url: String?, width: Int, height: Int) {
        requestManager.load(url).apply(requestOptions.override(width, height))
            .thumbnail(0.25f)
            .into(this)
    }

    override fun ImageView.loadWithGlide(url: String?) {
        requestManager.load(url).apply(requestOptions)
            .thumbnail(0.25f).into(this)
    }

    override fun ImageView.loadWithGlide(drawable: Drawable) {
        requestManager.load(drawable).into(this)
    }

    override fun ImageView.loadWithGlide(bitmap: Bitmap) {
        requestManager.load(bitmap).into(this)
    }
}