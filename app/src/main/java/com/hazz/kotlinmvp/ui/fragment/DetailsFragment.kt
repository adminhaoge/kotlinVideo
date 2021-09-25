package com.hazz.kotlinmvp.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment
import com.hazz.kotlinmvp.mvp.contract.DetailsContract
import com.hazz.kotlinmvp.mvp.model.bean.DetailsBean
import com.hazz.kotlinmvp.mvp.presenter.DetailsPresenter
import com.hazz.kotlinmvp.mvp.presenter.HomePresenter
import com.hazz.kotlinmvp.showToast
import com.hazz.kotlinmvp.ui.adapter.DetailsAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class DetailsFragment : BaseFragment(), DetailsContract.View {

    private lateinit var adapter: DetailsAdapter

    private val mPresenter by lazy { DetailsPresenter() }

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initView() {
        mPresenter.attachView(this)
        adapter = DetailsAdapter(this)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.itemAnimator = null
        mRefreshLayout.setOnRefreshListener {}
    }

    override fun lazyLoad() {
        mPresenter.requestHomeData()
    }

    override fun responseHomeData(detail: DetailsBean) {
        mRecyclerView.adapter = adapter.obtainDetailsData(detail)
    }

    override fun responseError(msg: String, errorCode: Int) {
        showToast(msg)
    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}