package com.hazz.kotlinmvp.functionbase

import androidx.fragment.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.mvp.model.bean.TabEntity
import com.hazz.kotlinmvp.ui.fragment.DiscoveryFragment
import com.hazz.kotlinmvp.utils.GlobalUtil

class HomePageFragment : BaseViewPagerFragment() {

    override val createTitles: ArrayList<CustomTabEntity>
        get() = ArrayList<CustomTabEntity>().apply {
            add(TabEntity(GlobalUtil.getString(R.string.discovery)))
            add(TabEntity(GlobalUtil.getString(R.string.commend)))
            add(TabEntity(GlobalUtil.getString(R.string.daily)))
        }

    override val createFragments: Array<Fragment>
        get() = arrayOf(DiscoveryFragment.newInstance())

    override fun getLayoutId(): Int {
        TODO("Not yet implemented")
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun lazyLoad() {
        TODO("Not yet implemented")
    }
}