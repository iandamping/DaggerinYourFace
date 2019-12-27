package com.junemon.daggerinyourface.view.publisher.detail

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
import com.junemon.daggerinyourface.R
import com.junemon.daggerinyourface.databinding.FragmentDetailGameBinding
import com.junemon.daggerinyourface.domain.model.ResultRemoteToConsume
import com.junemon.daggerinyourface.presentation.base.BaseFragment
import com.junemon.daggerinyourface.presentation.interfaces.LoadImageHelper
import com.junemon.daggerinyourface.presentation.model.mapToPresentation
import com.junemon.daggerinyourface.presentation.vm.PublisherPresentationViewModel
import com.junemon.daggerinyourface.view.root.RootActivity
import javax.inject.Inject

class PublisherDetailFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PublisherPresentationViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private lateinit var binding: FragmentDetailGameBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the rootActivityComponent from the Activity and injects this Fragment
        (activity as RootActivity).rootActivityComponent
            .getPublisherPresentationComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val detailID by lazy { PublisherDetailFragmentArgs.fromBundle(arguments!!).publisherID }
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_publisher, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            observeData(detailID)
        }
        return binding.root
    }

    fun FragmentDetailGameBinding.observeData(detailID: Int) {
        apply {
            viewModel.getDetailRemote(detailID).observe(viewLifecycleOwner, Observer { result ->
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
                consumeData(result.data?.mapToPresentation())
            })
        }
    }

    private fun FragmentDetailGameBinding.consumeData(result: com.junemon.daggerinyourface.presentation.model.PublisherDetailPresentation?) {
        tvDesc.text = result?.description
        tvName.text = result?.publisherName
        loadImageHelper.run {
            ivImagesDetail.loadWithGlide(result?.publisherImage)
        }
    }
}
