package com.hazz.kotlinmvp.ui.fragment

import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment
import com.hazz.kotlinmvp.ui.adapter.DetailsAdapter
import com.hazz.kotlinmvp.ui.adapter.FooterAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class DetailsFragment : BaseFragment() {

    private lateinit var adapter: DetailsAdapter

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initView() {
        adapter = DetailsAdapter(this)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.adapter = adapter.withLoadStateFooter(FooterAdapter { adapter.retry() })
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.itemAnimator = null
        mRefreshLayout.setOnRefreshListener { adapter.refresh() }
        addLoadStateListener()
    }

    override fun lazyLoad() {
        TODO("Not yet implemented")
    }


    private fun addLoadStateListener() {
        adapter.addLoadStateListener {
            when (it.refresh) {
                is LoadState.NotLoading -> {

                }
            }
        }
    }
}