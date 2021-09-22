package com.hazz.kotlinmvp.mvp.model.bean

import com.flyco.tablayout.listener.CustomTabEntity



/**
 * Created by xuhao on 2017/11/8.
 */
class TabEntity(var title: String, private var selectedIcon: Int = 0, private var unSelectedIcon: Int = 0) : CustomTabEntity {

    override fun getTabTitle(): String {
        return title
    }

    override fun getTabSelectedIcon(): Int {
        return selectedIcon
    }

    override fun getTabUnselectedIcon(): Int {
        return unSelectedIcon
    }
}