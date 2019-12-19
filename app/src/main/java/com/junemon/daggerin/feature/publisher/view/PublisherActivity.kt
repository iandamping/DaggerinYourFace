package com.junemon.daggerin.feature.publisher.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.junemon.daggerin.R
import com.junemon.daggerin.databinding.ActivityPublisherBinding
import com.junemon.daggerin.model.PublishersEntity
import javax.inject.Inject

class PublisherActivity : AppCompatActivity(),
    PublisherView {
    @Inject
    lateinit var presenter: PublisherPresenter

    /*private val publisherComponent by lazy {
        applicationComponent.getPublisherActivityComponent(
            PublisherActivityModule(
                this
            )
        )
    }*/
//    private val recyclerHelper by lazy {
//        publisherComponent.getRecyclerHelper()
//    }

//    private val loadImageHelper by lazy {
//        publisherComponent.getLoadImageHelper()
//    }
    private lateinit var binding: ActivityPublisherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        publisherComponent.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_publisher)
        presenter.apply {
            attachLifecycle(this@PublisherActivity)
            getData()
        }
    }

    override fun observeData(data: List<PublishersEntity>) {

//        if (::binding.isInitialized) {
//            binding.apply {
//                recyclerHelper.run {
//                    rvMain.setUpVerticalListAdapter(items = data,
//                        diffUtil = PublisherCallback.publisherDiffCallbacks,
//                        layoutResId = R.layout.item_publisher,
//                        bindHolder = {
//                            tvText.text = it.name
//                            loadImageHelper.run {
//                                ivImages.loadWithGlide(it.imageBackground)
//                            }
//                        }, itemClick = {
//                            val intent by lazy {
//                                Intent(
//                                    this@PublisherActivity,
//                                    MainActivity::class.java
//                                )
//                            }
//                            startActivity(intent)
//                        })
//                }
//            }
//        }
    }

    override fun observeFailed(throws: Throwable) {
        if (::binding.isInitialized) Snackbar.make(
            binding.mainRootsLayout,
            throws.localizedMessage,
            Snackbar.LENGTH_SHORT
        ).show()
    }
}