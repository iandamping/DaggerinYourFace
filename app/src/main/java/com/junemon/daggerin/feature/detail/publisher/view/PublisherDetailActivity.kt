package com.junemon.daggerin.feature.detail.publisher.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.base.adapter.BaseActivity
import com.junemon.daggerin.databinding.ActivityDetailPublisherBinding
import com.junemon.daggerin.di.injector.inject
import com.junemon.daggerin.model.publisher.PublisherDetailEntity
import com.junemon.daggerin.util.Constant
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import javax.inject.Inject

class PublisherDetailActivity:BaseActivity(),PublisherDetailView {
    private val detailID by lazy { intent.getIntExtra(Constant.intentPublisherDetailKey,0) }

    @Inject
    lateinit var presenter: PublisherDetailPresenter

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private lateinit var binding: ActivityDetailPublisherBinding

    private fun daggerInjection() {
        inject().getPublisherDetailActivityComponent().inject(this).injectActivity(this)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        daggerInjection()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_publisher)
        lifecycleScope.launchWhenStarted {
            presenter.getData(detailID)
        }

    }
    override fun observeData(data: PublisherDetailEntity) {
        if (::binding.isInitialized){
            binding.apply {
                tvDesc.text = data.description
                tvName.text = data.publisherName
                loadImageHelper.run {
                    ivImagesDetail.loadWithGlide(data.publisherImage)
                }
            }
        }
    }

    override fun observeFailed(throws: Throwable) {
        if (::binding.isInitialized) Snackbar.make(
            binding.mainRootLayout,
            throws.localizedMessage,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun setDialogShow(data: Boolean) {
        openDialog(data)
    }
}