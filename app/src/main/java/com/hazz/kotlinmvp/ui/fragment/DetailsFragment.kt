package com.hazz.kotlinmvp.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class DetailsFragment : BaseFragment() {

    private lateinit var adapter: DiscoveryAdapter

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initView() {
        adapter = DiscoveryAdapter(this)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.adapter = adapter.
    }

    override fun lazyLoad() {
        TODO("Not yet implemented")
    }
}