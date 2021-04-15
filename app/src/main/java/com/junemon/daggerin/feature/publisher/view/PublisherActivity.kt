package com.junemon.daggerin.feature.publisher.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseActivity
import com.junemon.daggerin.databinding.ActivityPublisherBinding
import com.junemon.daggerin.db.publisher.PublisherDbEntity
import com.junemon.daggerin.feature.detail.game.view.GameDetailActivity
import com.junemon.daggerin.model.publisher.PublisherCallback
import com.junemon.daggerin.model.state.Results
import com.junemon.daggerin.util.Constant
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import kotlinx.android.synthetic.main.item_publisher.view.*
import javax.inject.Inject

class PublisherActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PublisherViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private fun daggerInjection() {
        (application as MainApplication)
            .appComponent.getPublisherActivityComponent().create().inject(this)
    }

    private lateinit var binding: ActivityPublisherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        daggerInjection()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_publisher)
        observeData()
    }

    private fun observeData() {
        viewModel.getData().observe(this) {
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

    private fun ActivityPublisherBinding.consumeData(result: List<PublisherDbEntity>) {
        with(recyclerHelper) {
            rvMain.setUpVerticalListAdapter(items = result,
                diffUtil = PublisherCallback.publisherDiffCallbacks,
                layoutResId = R.layout.item_games,
                bindHolder = {
                    tvText.text = it.publisherName
                    loadImageHelper.run {
                        ivImages.loadWithGlide(it.publisherImage)
                    }
                }, itemClick = {
                    val intent by lazy {
                        Intent(
                            this@PublisherActivity,
                            GameDetailActivity::class.java
                        )
                    }
                    intent.putExtra(Constant.intentGamesDetailKey, publisherId)
                    startActivity(intent)
                })
        }
    }
}
