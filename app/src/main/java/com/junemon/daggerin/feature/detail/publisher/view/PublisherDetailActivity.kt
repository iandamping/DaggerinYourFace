package com.junemon.daggerin.feature.detail.publisher.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseActivity
import com.junemon.daggerin.base.ResultRemoteToConsume
import com.junemon.daggerin.databinding.ActivityDetailPublisherBinding
import com.junemon.daggerin.model.publisher.PublisherDetailEntity
import com.junemon.daggerin.util.Constant
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import javax.inject.Inject

class PublisherDetailActivity : BaseActivity() {
    private val detailID by lazy { intent.getIntExtra(Constant.intentPublisherDetailKey, 0) }
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PublisherDetailViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private lateinit var binding: ActivityDetailPublisherBinding

    private fun daggerInjection() {
        (application as MainApplication)
            .appComponent.getPublisherDetailActivityComponent().create().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInjection()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_publisher)
        binding.apply {
            lifecycleOwner = this@PublisherDetailActivity
            observeData(detailID)
        }
    }

    fun ActivityDetailPublisherBinding.observeData(detailID: Int) {
        apply {
            viewModel.getData(detailID).observe(this@PublisherDetailActivity, Observer { result ->
                when (result.status) {
                    ResultRemoteToConsume.Status.ERROR -> {
                        setDialogShow(true)
                        Snackbar.make(
                            mainRootLayout,
                            result.message!!,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    ResultRemoteToConsume.Status.SUCCESS -> {
                        setDialogShow(true)
                    }
                    else -> {
                        setDialogShow(false)
                    }
                }
                consumeData(result)
            })
        }
    }

    private fun ActivityDetailPublisherBinding.consumeData(result: ResultRemoteToConsume<PublisherDetailEntity>) {
        tvDesc.text = result.data?.description
        tvName.text = result.data?.publisherName
        loadImageHelper.run {
            ivImagesDetail.loadWithGlide(result.data?.publisherImage)
        }
    }
}
