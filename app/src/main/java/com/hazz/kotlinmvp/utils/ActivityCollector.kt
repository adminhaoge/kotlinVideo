package com.hazz.kotlinmvp.utils

import android.app.Activity
import java.lang.ref.WeakReference
import java.util.*

/**
 * 管理应用程序中所有Activity。
 *  @author xuzhonghao
 *  @since 2021.9.16
 */
object ActivityCollector {

    private val activityS = Stack<WeakReference<Activity>>()

    /**
     * 将Activity压入Application栈
     *
     * @param task 将要压入栈的Activity对象
     */
    fun pushTask(task: WeakReference<Activity>?) {
        activityS.push(task)
    }

    /**
     * 将传入的Activity对象从栈中移除
     *
     * @param task
     */
    fun removeTask(task: WeakReference<Activity>?) {
        activityS.remove(task)
    }

    /**
     * 根据指定位置从栈中移除Activity
     *
     * @param taskIndex Activity栈索引
     */

    fun removeIndexTask(taskIndex: Int) {
        if (activityS.size > taskIndex) activityS.removeAt(taskIndex)
    }

    /**
     * 将栈中Activity移除至栈顶
     */
    fun removeToTop() {
        val end = activityS.size
        val start = 1
        for (i in end - 1 downTo start) {
            val mActivity = activityS[i].get()
            if (null != mActivity && !mActivity.isFinishing) {
                mActivity.finish()
            }
        }
    }

    /**
     * 移除全部（用于整个应用退出）
     */
    fun removeAll() {
        for (task in activityS) {
            val mActivity = task.get()
            if (null != mActivity && !mActivity.isFinishing) {
                mActivity.finish()
            }
        }
    }
}