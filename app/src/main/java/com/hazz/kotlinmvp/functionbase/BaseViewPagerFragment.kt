package com.hazz.kotlinmvp.functionbase

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.flyco.tablayout.CommonTabLayout
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment
/**
 * Fragment基类，适用场景：页面含有ViewPager+TabLayout的界面。
 *
 * 附加： 如果xml视图布局增加了MultipleStatusView那么就可以增加一个加载失败、成功、加载中的过渡视图
 *
 * @author xuzhonghao
 * @since  2021/9/22
 */
abstract class BaseViewPagerFragment : BaseFragment() {

    private val TAG: String? = this.javaClass.simpleName

    protected var ivSearch: ImageView? = null

    protected var viewPager: ViewPager? = null

    protected var tabLayout: CommonTabLayout? = null

    protected val adapter: VpAdapter by lazy { VpAdapter(requireActivity().supportFragmentManager).apply { addFragments(createFragments) } }

    protected var offscreenPageLimit = 1

    abstract val createTitles: ArrayList<CustomTabEntity>

    abstract val createFragments: Array<Fragment>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    open fun setupViews() {
        //TODO 可以用于toolBar的初始化

        initViewPager()
    }

    protected fun initViewPager() {
        viewPager = rootView?.findViewById(R.id.viewPager)
        tabLayout = rootView?.findViewById(R.id.tabLayout)

        viewPager?.offscreenPageLimit = offscreenPageLimit
        viewPager?.adapter = adapter
        tabLayout?.setTabData(createTitles)
        tabLayout?.setOnTabSelectListener(object : OnTabSelectListener{
            override fun onTabSelect(position: Int) {
                viewPager?.currentItem = position
            }

            override fun onTabReselect(position: Int) {

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (rootView?.parent != null) (rootView?.parent as ViewGroup).removeView(rootView)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    inner class VpAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

        private val fragments = mutableListOf<Fragment>()

        fun addFragments(fragment: Array<Fragment>) {
            fragments.addAll(fragment)
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

    }

}




