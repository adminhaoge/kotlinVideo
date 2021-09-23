package com.hazz.kotlinmvp.extension

import android.view.View
import android.widget.ImageView


/**
 * 用于给view控件显示隐藏的通用函数方法
 */
fun View.visible() {
    this?.visibility = View.VISIBLE
}

fun View.gone() {
    this?.visibility = View.GONE
}