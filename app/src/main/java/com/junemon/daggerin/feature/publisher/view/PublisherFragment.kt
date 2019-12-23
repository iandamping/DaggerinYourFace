package com.junemon.daggerin.feature.publisher.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseFragment
import com.junemon.daggerin.base.ResultToConsume
import com.junemon.daggerin.databinding.ActivityPublisherBinding
import com.junemon.daggerin.db.publisher.PublisherDbEntity
import com.junemon.daggerin.feature.detail.game.view.GameDetailFragment
import com.junemon.daggerin.feature.root.RootActivity
import com.junemon.daggerin.model.publisher.PublisherCallback
import com.junemon.daggerin.util.Constant
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import javax.inject.Inject
import kotlinx.android.synthetic.main.item_publisher.view.*

class PublisherFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PublisherViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private lateinit var binding: ActivityPublisherBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the rootActivityComponent from the Activity and injects this Fragment
        (activity as RootActivity).rootActivityComponent
            .getPublisherComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_publisher, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            observeData()
        }
        return binding.root
    }

    fun ActivityPublisherBinding.observeData() {
        apply {
            viewModel.getData().observe(viewLifecycleOwner, Observer { result ->
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
                   this@consumeData.root.findNavController().navigate(PublisherFragmentDirections.actionPublisherFragmentToPublisherDetailFragment(publisherId))
                })
        }
    }
}
