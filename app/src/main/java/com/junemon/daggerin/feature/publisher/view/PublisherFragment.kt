package com.junemon.daggerin.feature.publisher.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.R
import com.junemon.daggerin.databinding.ActivityPublisherBinding
import com.junemon.daggerin.db.publisher.PublisherDbEntity
import com.junemon.daggerin.feature.root.RootActivity
import com.junemon.daggerin.model.publisher.PublisherCallback
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import com.junemon.daggerin.util.interfaces.RecyclerHelper
import kotlinx.android.synthetic.main.item_publisher.view.*
import javax.inject.Inject

class PublisherFragment : Fragment(),
    PublisherView {
    @Inject
    lateinit var presenter: PublisherPresenter

    @Inject
    lateinit var recyclerHelper: RecyclerHelper

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Grabs the rootActivityComponent from the Activity and injects this Fragment
        (activity as RootActivity).rootActivityComponent.getPublisherComponent().inject(this)
            .inject(this)
    }

    private lateinit var binding: ActivityPublisherBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_publisher, container, false)
        presenter.apply {
            attachLifecycle(this@PublisherFragment)
            getData()
        }
        return binding.root
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
                            this@apply.root.findNavController().navigate(
                                PublisherFragmentDirections.actionPublisherFragmentToPublisherDetailFragment(
                                    publisherId
                                )
                            )
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
}