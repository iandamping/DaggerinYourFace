package com.junemon.daggerin.feature.detail.publisher.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.base.BaseFragment
import com.junemon.daggerin.base.ResultRemoteToConsume
import com.junemon.daggerin.databinding.ActivityDetailPublisherBinding
import com.junemon.daggerin.feature.detail.game.view.GameDetailFragmentArgs
import com.junemon.daggerin.feature.root.RootActivity
import com.junemon.daggerin.model.publisher.PublisherDetailEntity
import com.junemon.daggerin.util.Constant
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import javax.inject.Inject

class PublisherDetailFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PublisherDetailViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private lateinit var binding: ActivityDetailPublisherBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the rootActivityComponent from the Activity and injects this Fragment
        (activity as RootActivity).rootActivityComponent
            .getPublisherDetailComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val detailID by lazy { PublisherDetailFragmentArgs.fromBundle(arguments!!).publisherID }
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_detail_publisher, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            observeData(detailID)
        }
        return binding.root
    }


    fun ActivityDetailPublisherBinding.observeData(detailID: Int) {
        apply {
            viewModel.getData(detailID).observe(viewLifecycleOwner, Observer { result ->
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
