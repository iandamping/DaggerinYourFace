package com.junemon.daggerinyourface.view.publisher

import android.content.Context
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
import com.junemon.daggerinyourface.R
import com.junemon.daggerinyourface.databinding.FragmentPublisherBinding
import com.junemon.daggerinyourface.model.domain.ResultToConsume
import com.junemon.daggerinyourface.model.presentation.dto.publisher.mapToPresentation
import com.junemon.daggerinyourface.presentation.Constant.publisherDiffCallbacks
import com.junemon.daggerinyourface.presentation.base.BaseFragment
import com.junemon.daggerinyourface.presentation.interfaces.LoadImageHelper
import com.junemon.daggerinyourface.model.presentation.publisher.PublisherPresentation
import com.junemon.daggerinyourface.presentation.util.interfaces.RecyclerHelper
import com.junemon.daggerinyourface.presentation.vm.PublisherPresentationViewModel
import com.junemon.daggerinyourface.view.root.RootActivity
import javax.inject.Inject
import kotlinx.android.synthetic.main.item_publisher.view.*

class PublisherFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PublisherPresentationViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private lateinit var binding: FragmentPublisherBinding

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_publisher, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            observeData()
        }
        return binding.root
    }

    fun FragmentPublisherBinding.observeData() {
        apply {
            viewModel.getCache().observe(viewLifecycleOwner, Observer { result ->
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
                textView3.setOnClickListener {
                    it.findNavController().navigate(PublisherFragmentDirections.actionPublisherFragmentToPublisherPagingFragment())
                }
                consumeData(result?.data?.mapToPresentation())
            })
        }
    }

    private fun FragmentPublisherBinding.consumeData(result: List<PublisherPresentation>?) {
        recyclerHelper.run {
            rvMain.setUpVerticalListAdapter(items = result,
                diffUtil = publisherDiffCallbacks,
                layoutResId = R.layout.item_publisher,
                bindHolder = {
                    tvText.text = it.publisherName
                    loadImageHelper.run {
                        ivImages.loadWithGlide(it.publisherImage)
                    }
                }, itemClick = {
                    this@consumeData.root.findNavController().navigate(
                        PublisherFragmentDirections.actionPublisherFragmentToPublisherDetailFragment(
                            publisherId
                        )
                    )
                })
        }
    }
}
