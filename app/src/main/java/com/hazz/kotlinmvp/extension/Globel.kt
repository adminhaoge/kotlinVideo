package com.hazz.kotlinmvp.extension

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import com.hazz.kotlinmvp.MyApplication
import com.hazz.kotlinmvp.dialog.ShareDialogFragment
import java.util.prefs.Preferences

/**
 * 弹出分享对话框。
 *
 * @param activity 上下文
 * @param shareContent 分享内容
 */
fun showDialogShare(activity: Activity, shareContent: String) {
    if (activity is AppCompatActivity) {
        ShareDialogFragment().showDialog(activity, shareContent)
    }
}