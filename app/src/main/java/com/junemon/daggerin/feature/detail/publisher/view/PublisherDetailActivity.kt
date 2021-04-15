package com.junemon.daggerin.feature.detail.publisher.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseActivity
import com.junemon.daggerin.databinding.ActivityDetailPublisherBinding
import com.junemon.daggerin.model.publisher.PublisherDetailEntity
import com.junemon.daggerin.model.state.Results
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
        super.onCreate(savedInstanceState)
        daggerInjection()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_publisher)
        observeData(detailID)
    }

    private fun observeData(detailID: Int) {
        viewModel.getData(detailID).observe(this) {
            when (it) {
                is Results.Error -> {
                    setDialogShow(true)
                    Snackbar.make(
                        binding.root,
                        it.message,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                Results.Loading -> setDialogShow(false)
                is Results.Success -> {
                    setDialogShow(true)
                    binding.consumeData(it.data)
                }
            }
        }

    }

    private fun ActivityDetailPublisherBinding.consumeData(result: PublisherDetailEntity) {
        tvDesc.text = result.description
        tvName.text = result.publisherName
        loadImageHelper.run {
            ivImagesDetail.loadWithGlide(result.publisherImage)
        }
    }
}
