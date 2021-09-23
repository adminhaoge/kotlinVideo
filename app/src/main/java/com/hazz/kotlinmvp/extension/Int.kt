package com.hazz.kotlinmvp.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

//用于xml解析inflate的时候使用的函数
/**
 * 解析xml布局
 *
 * @param parent 父布局
 * @param attachToRoot 是否依附到父布局
 */
fun Int.inflate(parent: ViewGroup, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(parent.context).inflate(this, parent, attachToRoot)
}
