package com.hazz.kotlinmvp.ui.fragment

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

    }

    override fun lazyLoad() {
        TODO("Not yet implemented")
    }
}