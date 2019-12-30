package com.junemon.daggerinyourface.view.publisher.paging

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
import androidx.paging.PagedList
import com.junemon.daggerinyourface.R
import com.junemon.daggerinyourface.databinding.FragmentPagingPublisherBinding
import com.junemon.daggerinyourface.model.domain.publisher.PublisherPagingData
import com.junemon.daggerinyourface.presentation.Constant
import com.junemon.daggerinyourface.presentation.base.BaseFragment
import com.junemon.daggerinyourface.presentation.interfaces.LoadImageHelper
import com.junemon.daggerinyourface.presentation.util.interfaces.RecyclerHelper
import com.junemon.daggerinyourface.presentation.vm.PublisherPresentationViewModel
import com.junemon.daggerinyourface.view.root.RootActivity
import javax.inject.Inject
import kotlinx.android.synthetic.main.item_games.view.*

class PublisherPagingFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PublisherPresentationViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private lateinit var binding: FragmentPagingPublisherBinding

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_paging_publisher, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            observeData()
        }
        return binding.root
    }

    fun FragmentPagingPublisherBinding.observeData() {
        apply {
            viewModel.getPaginationCache().observe(viewLifecycleOwner, Observer { result ->
                consumeData(result)
            })
        }
    }

    private fun FragmentPagingPublisherBinding.consumeData(result: PagedList<PublisherPagingData>?) {
        recyclerHelper.run {
            rvMain.setUpPagingVertical(items = result,
                diffUtil = Constant.publisherPagingDiffCallbacks,
                layoutResId = R.layout.item_publisher,
                bindHolder = {
                    tvText.text = it.publisherName
                    loadImageHelper.run {
                        ivImages.loadWithGlide(it.publisherImage)
                    }
                }, itemClick = {
                    this@consumeData.root.findNavController().navigate(
                        PublisherPagingFragmentDirections.actionPublisherPagingFragmentToPublisherDetailFragment(
                            publisherId
                        )
                    )
                })
        }
    }
}
