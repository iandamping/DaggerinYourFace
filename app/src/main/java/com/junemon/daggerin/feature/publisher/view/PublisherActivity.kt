package com.junemon.daggerin.feature.publisher.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.base.adapter.BaseActivity
import com.junemon.daggerin.databinding.ActivityPublisherBinding
import com.junemon.daggerin.db.publisher.PublisherDbEntity
import com.junemon.daggerin.di.injector.inject
import com.junemon.daggerin.feature.detail.publisher.view.PublisherDetailActivity
import com.junemon.daggerin.feature.main.view.MainActivity
import com.junemon.daggerin.model.publisher.PublisherCallback
import com.junemon.daggerin.util.Constant.intentPublisherDetailKey
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import kotlinx.android.synthetic.main.item_publisher.view.*
import javax.inject.Inject

class PublisherActivity : BaseActivity(),
    PublisherView {
    @Inject
    lateinit var presenter: PublisherPresenter

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private fun daggerInjection() {
        inject().getPublisherActivityComponent().inject(this).injectActivity(this)

    }

    private lateinit var binding: ActivityPublisherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        daggerInjection()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_publisher)
        lifecycleScope.launchWhenStarted {
            presenter.getData()
        }
    }

    override fun observeData(data: List<PublisherDbEntity>) {
        if (::binding.isInitialized) {
            binding.apply {
                recyclerHelper.run {
                    rvMain.setUpVerticalListAdapter(items = data,
                        diffUtil = PublisherCallback.publisherDiffCallbacks,
                        layoutResId = R.layout.item_publisher,
                        bindHolder = {
                            tvText.text = it.publisherName
                            loadImageHelper.run {
                                ivImages.loadWithGlide(it.publisherImage)
                            }
                        }, itemClick = {
                            val intent by lazy {
                                Intent(
                                    this@PublisherActivity,
                                    PublisherDetailActivity::class.java
                                )
                            }
                            intent.putExtra(intentPublisherDetailKey,publisherId)
                            startActivity(intent)
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

    override fun setDialogShow(data: Boolean) {
        openDialog(data)
    }
}