package com.junemon.daggerin.feature.publisher.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseActivity
import com.junemon.daggerin.base.ResultToConsume
import com.junemon.daggerin.databinding.ActivityPublisherBinding
import com.junemon.daggerin.db.publisher.PublisherDbEntity
import com.junemon.daggerin.feature.detail.game.view.GameDetailActivity
import com.junemon.daggerin.model.publisher.PublisherCallback
import com.junemon.daggerin.util.Constant
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import javax.inject.Inject
import kotlinx.android.synthetic.main.item_publisher.view.*

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
        daggerInjection()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_publisher)
        binding.apply {
            lifecycleOwner = this@PublisherActivity
            observeData()
        }
    }

    fun ActivityPublisherBinding.observeData() {
        apply {
            viewModel.getData().observe(this@PublisherActivity, Observer { result ->
                when (result) {
                    is ResultToConsume.Success -> {
                        setDialogShow(true)
                    }
                    is ResultToConsume.Error -> {
                        setDialogShow(true)
                        Snackbar.make(
                            mainRootsLayout,
                            result.message!!,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        setDialogShow(false)
                    }
                }
                consumeData(result)
            })
        }
    }

    private fun ActivityPublisherBinding.consumeData(result: ResultToConsume<List<PublisherDbEntity>>) {
        recyclerHelper.run {
            rvMain.setUpVerticalListAdapter(items = result.data,
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
