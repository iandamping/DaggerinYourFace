package com.junemon.daggerin.feature.detail.publisher.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication
import com.junemon.daggerin.R
import com.junemon.daggerin.databinding.ActivityDetailPublisherBinding
import com.junemon.daggerin.feature.root.RootActivity
import com.junemon.daggerin.model.publisher.PublisherDetailEntity
import com.junemon.daggerin.util.Constant
import com.junemon.daggerin.util.interfaces.LoadImageHelper
import javax.inject.Inject

class PublisherDetailFragment:Fragment(),PublisherDetailView {
    private val detailID by lazy { PublisherDetailFragmentArgs.fromBundle(arguments!!).publisherID }

    @Inject
    lateinit var presenter: PublisherDetailPresenter

    @Inject
    lateinit var loadImageHelper: LoadImageHelper

    private lateinit var binding: ActivityDetailPublisherBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the rootActivityComponent from the Activity and injects this Fragment
        (activity as RootActivity).rootActivityComponent
            .getPublisherDetailComponent().inject(this).injectFragment(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.activity_detail_publisher,container,false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }
        presenter.apply {
            attachLifecycle(this@PublisherDetailFragment)
            getData(detailID)
        }
        return binding.root
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
}