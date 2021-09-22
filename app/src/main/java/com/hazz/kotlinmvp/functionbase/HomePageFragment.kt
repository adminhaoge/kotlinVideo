package com.hazz.kotlinmvp.functionbase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eyepetizer.android.event.MessageEvent
import com.eyepetizer.android.event.RefreshEvent
import com.eyepetizer.android.event.SwitchPagesEvent
import com.flyco.tablayout.listener.CustomTabEntity
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.mvp.model.bean.TabEntity
import com.hazz.kotlinmvp.ui.fragment.DiscoveryFragment
import com.hazz.kotlinmvp.utils.GlobalUtil
import kotlinx.android.synthetic.main.layout_main_page_title_bar.*
import org.greenrobot.eventbus.EventBus

class HomePageFragment : BaseViewPagerFragment() {

    override val createTitles: ArrayList<CustomTabEntity>
        get() = ArrayList<CustomTabEntity>().apply {
            add(TabEntity(GlobalUtil.getString(R.string.discovery)))
            add(TabEntity(GlobalUtil.getString(R.string.commend)))
            add(TabEntity(GlobalUtil.getString(R.string.daily)))
        }

    override val createFragments: Array<Fragment>
        get() = arrayOf()



    override fun getLayoutId(): Int {
        return R.layout.fragment_main_container
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivCalendar.visibility = View.VISIBLE
        viewPager?.currentItem = 1
    }


    override fun onMessageEvent(messageEvent: MessageEvent) {
        super.onMessageEvent(messageEvent)
        if (messageEvent is RefreshEvent && this::class.java == messageEvent.activityClass) {
            when (viewPager?.currentItem) {
                0 -> EventBus.getDefault().post(RefreshEvent(DiscoveryFragment::class.java))
                1 -> EventBus.getDefault().post(RefreshEvent(CommendFragment::class.java))
                2 -> EventBus.getDefault().post(RefreshEvent(DailyFragment::class.java))
                else -> {
                }
            }
        }else if (messageEvent is SwitchPagesEvent) {
            when (messageEvent.activityClass) {
                DiscoveryFragment::class.java -> viewPager?.currentItem = 0
                CommendFragment::class.java -> viewPager?.currentItem = 1
                DailyFragment::class.java -> viewPager?.currentItem = 2
                else -> {
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun lazyLoad() {
        TODO("Not yet implemented")
    }
}