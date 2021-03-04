package com.junemon.daggerin.feature.publisher.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.R
import com.junemon.daggerin.databinding.ActivityPublisherBinding
import com.junemon.daggerin.model.PublisherCallback
import com.junemon.daggerin.model.PublishersEntity
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.item_publisher.view.*
import javax.inject.Inject

@AndroidEntryPoint
class PublisherActivity : AppCompatActivity(),
    PublisherView {

    @Inject
    lateinit var presenter: PublisherPresenter

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper


    private lateinit var binding: ActivityPublisherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_publisher)
        presenter.apply {
            attachLifecycle(this@PublisherActivity)
            getData()
        }

    }

    override fun observeData(data: List<PublishersEntity>) {
        if (::binding.isInitialized) {
            binding.apply {
                recyclerHelper.run {
                    rvMain.setUpVerticalListAdapter(items = data,
                        diffUtil = PublisherCallback.publisherDiffCallbacks,
                        layoutResId = R.layout.item_publisher,
                        bindHolder = {
                            tvText.text = it.name
                            loadImageHelper.run {
                                ivImages.loadWithGlide(it.imageBackground)
                            }
                        })
                }
            }
        }
    }

    override fun observeFailed(throws: Throwable) {
        if (::binding.isInitialized) Snackbar.make(
            binding.mainRootsLayout,
            throws.localizedMessage,
            Snackbar.LENGTH_SHORT
        ).show()
    }
}