package com.junemon.daggerin.feature.publisher.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.MainApplication.appComponent.component
import com.junemon.daggerin.R
import com.junemon.daggerin.databinding.ActivityPublisherBinding
import com.junemon.daggerin.feature.publisher.module.PublisherActivityModule
import com.junemon.daggerin.model.PublishersEntity
import javax.inject.Inject

class PublisherActivity : AppCompatActivity(),
    PublisherView {

    @Inject lateinit var presenter: PublisherPresenter
    private val publisherComponent by lazy {
        component.getPublisherActivityComponent(
            PublisherActivityModule(
                this
            )
        )
    }
    private val adapter: PublisherAdapter by lazy { PublisherAdapter() }
    private lateinit var binding: ActivityPublisherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        publisherComponent.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_publisher)
        presenter.apply {
            attachLifecycle(this@PublisherActivity)
            getData()
        }
    }

    override fun observeData(data: List<PublishersEntity>) {
        adapter.submitList(data)
        if (::binding.isInitialized) {
            binding.apply {
                rvMain.layoutManager = LinearLayoutManager(this@PublisherActivity)
                rvMain.adapter = adapter
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