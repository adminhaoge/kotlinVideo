package com.hazz.kotlinmvp.utils

import android.app.Activity
import com.eyepetizer.android.event.RefreshEvent
import com.eyepetizer.android.event.SwitchPagesEvent
import com.hazz.kotlinmvp.Constants
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.base.BaseFragment
import com.hazz.kotlinmvp.extension.showToast
import org.greenrobot.eventbus.EventBus
import java.net.URLDecoder

/**
 * actionUrl事件处理工具类。通过截取actionUrl相关信息，并进行相应事件处理。
 *
 * @author xuzhonghao
 * @since  2021/9/20
 */
object ActionUrlUtil {
    /**
     * 处理ActionUrl事件。
     *
     * @param fragment 上下文环境
     * @param actionUrl 待处理的url
     * @param toastTitle toast提示标题 or 没有匹配的事件需要处理，给出的提示标题。
     */
    fun process(fragment: BaseFragment, actionUrl: String?, toastTile: String = "") {
        process(fragment.requireActivity(), actionUrl, toastTile)
    }

    private fun process(fragment: Activity, actionUrl: String?, toastTile: String) {
        if (actionUrl == null) return
        val decodeUrl = URLDecoder.decode(actionUrl,"UTF-8")
        when {
            decodeUrl.startsWith(Constants.ActionUrl.WEBVIEW) -> {

            }
            decodeUrl.startsWith(Constants.ActionUrl.RANKLIST) -> {
                "${toastTile},${GlobalUtil.getString(R.string.currently_not_supported)}".showToast()
            }
            decodeUrl.startsWith(Constants.ActionUrl.TAG) -> {
                "${toastTile},${GlobalUtil.getString(R.string.currently_not_supported)}".showToast()
            }
            decodeUrl.startsWith(Constants.ActionUrl.HP_SEL_TAB_TWO_NEWTAB_MINUS_THREE) -> {
                EventBus.getDefault().post(SwitchPagesEvent(DailyFragment::class.java))
            }
            decodeUrl.startsWith(Constants.ActionUrl.CM_TAGSQUARE_TAB_ZERO) -> {
                "${toastTile},${GlobalUtil.getString(R.string.currently_not_supported)}".showToast()
            }
            decodeUrl.startsWith(Constants.ActionUrl.CM_TOPIC_SQUARE) -> {
                "${toastTile},${GlobalUtil.getString(R.string.currently_not_supported)}".showToast()
            }
            decodeUrl.startsWith(Constants.ActionUrl.CM_TOPIC_SQUARE_TAB_ZERO) -> {
                "${toastTile},${GlobalUtil.getString(R.string.currently_not_supported)}".showToast()
            }
            decodeUrl.startsWith(Constants.ActionUrl.COMMON_TITLE) -> {
                "${toastTile},${GlobalUtil.getString(R.string.currently_not_supported)}".showToast()
            }
            decodeUrl.startsWith(Constants.ActionUrl.HP_NOTIFI_TAB_ZERO) -> {
                EventBus.getDefault().post(SwitchPagesEvent(PushFragment::class.java))
                EventBus.getDefault().post(RefreshEvent(PushFragment::class.java))
            }
            decodeUrl.startsWith(Constants.ActionUrl.TOPIC_DETAIL) -> {
                "${toastTile},${GlobalUtil.getString(R.string.currently_not_supported)}".showToast()
            }
            decodeUrl.startsWith(Constants.ActionUrl.DETAIL) -> {
                getConversionVideoId(actionUrl)?.run { NewDetailActivity.start(activity, this) }
            }
            else -> {
                "${toastTile},${GlobalUtil.getString(R.string.currently_not_supported)}".showToast()
            }
        }
    }



    /**
     *  截取视频id。
     *
     *  @param actionUrl 解码后的actionUrl
     *  @return 视频id
     */
    private fun getConversionVideoId(actionUrl: String?): Long? {
        return try {
            val list = actionUrl?.split(Constants.ActionUrl.DETAIL)
            list!![1].toLong()
        }catch (e: Exception) {
            null
        }
    }
}