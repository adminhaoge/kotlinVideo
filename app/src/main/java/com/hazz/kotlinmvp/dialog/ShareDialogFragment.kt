package com.hazz.kotlinmvp.dialog

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hazz.kotlinmvp.Constants
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.extension.TOP_DRAWABLE_ICON
import com.hazz.kotlinmvp.extension.setDrawable
import com.hazz.kotlinmvp.utils.ShareUtil
import com.hazz.kotlinmvp.utils.ShareUtil.SHARE_MORE
import com.hazz.kotlinmvp.utils.ShareUtil.SHARE_QQ
import com.hazz.kotlinmvp.utils.ShareUtil.SHARE_QQZONE
import com.hazz.kotlinmvp.utils.ShareUtil.SHARE_WECHAT
import com.hazz.kotlinmvp.utils.ShareUtil.share
import com.umeng.analytics.MobclickAgent
import kotlinx.android.synthetic.main.fragment_share_dialog.*

class ShareDialogFragment : BottomSheetDialogFragment() {
    private var mShareDialog : View? = null

    private val binding
        get() = mShareDialog!!

    private lateinit var attachedActivity: Activity

    private lateinit var shareContent: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mShareDialog = inflater.inflate(R.layout.fragment_share_dialog, container, false)
        return binding
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mShareDialog = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            tvToWechatFriends.setDrawable(ContextCompat.getDrawable(it, R.drawable.ic_share_wechat_black_30dp),30f,30f,TOP_DRAWABLE_ICON)
            tvShareToWeibo.setDrawable(ContextCompat.getDrawable(it, R.drawable.ic_share_weibo_black_30dp),30f,30f,TOP_DRAWABLE_ICON)
            tvShareToQQ.setDrawable(ContextCompat.getDrawable(it, R.drawable.ic_share_qq_black_30dp),30f,30f, TOP_DRAWABLE_ICON)
            tvShareToQQzone.setDrawable(ContextCompat.getDrawable(it, R.drawable.ic_share_qq_zone_black_30dp),30f,30f, TOP_DRAWABLE_ICON)

            tvShareToQQ.setOnClickListener{
                share(attachedActivity, shareContent, SHARE_QQ)
                dismiss()
            }
            tvToWechatFriends.setOnClickListener {
                share(attachedActivity,shareContent, SHARE_WECHAT)
                dismiss()
            }
            tvShareToWeibo.setOnClickListener {
                share(attachedActivity, shareContent, SHARE_QQZONE)
                dismiss()
            }
            llMore.setOnClickListener {
                share(attachedActivity, shareContent, SHARE_MORE)
                dismiss()
            }
            tvCancel.setOnClickListener {
                dismiss()
            }
        }
    }

    fun showDialog(activity: AppCompatActivity, shareContent: String) {
        //TODO web的编写
//        if (shareContent.contains(WebViewActivity.DEFAULT_URL)) {
//            MobclickAgent.onEvent(activity, Constants.Mobclick.UMENG_EVENT1)
//        } else {
//            MobclickAgent.onEvent(activity, Constants.Mobclick.UMENG_EVENT2)
//        }
        show(activity.supportFragmentManager, "share_dialog")
        this.shareContent = shareContent
    }
}