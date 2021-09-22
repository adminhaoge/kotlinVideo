package com.hazz.kotlinmvp.extension

import android.graphics.drawable.Drawable
import android.widget.TextView

/**
 * 设置TextView图标
 *
 * @param drawable     图标
 * @param iconWidth    图标宽dp：默认自动根据图标大小
 * @param iconHeight   图标高dp：默认自动根据图标大小
 * @param direction    图标方向，0左 1上 2右 3下 默认图标位于左侧0
 */

val LEFT_DRAWABLE_ICON = 0

val TOP_DRAWABLE_ICON = 1

val RIGHT_DRAWABLE_ICON = 2

val BOTTOM_DRAWABLE_ICON = 3

fun TextView.setDrawable(drawable: Drawable?, iconHeight: Float? = null, iconWidth: Float? = null, direction: Int = 0) {
    if (iconWidth != null && iconHeight != null) {
        //第一个0是距左边距离，第二个0是距上边距离，iconWidth、iconHeight 分别是长宽
        drawable?.setBounds(0, 0, dp2px(iconWidth), dp2px(iconHeight))
    }
    when (direction) {
        LEFT_DRAWABLE_ICON -> setCompoundDrawables(drawable,null, null, null)
        TOP_DRAWABLE_ICON -> setCompoundDrawables(null, drawable, null, null)
        RIGHT_DRAWABLE_ICON -> setCompoundDrawables(null, null, drawable, null)
        BOTTOM_DRAWABLE_ICON -> setCompoundDrawables(null, null, null, drawable)
        else -> throw NoSuchMethodError()
    }
}

/**
 * 设置TextView图标
 *
 * @param lDrawable     左边图标
 * @param rDrawable     右边图标
 * @param lIconWidth    图标宽dp：默认自动根据图标大小
 * @param lIconHeight   图标高dp：默认自动根据图标大小
 * @param rIconWidth    图标宽dp：默认自动根据图标大小
 * @param rIconHeight   图标高dp：默认自动根据图标大小
 */

fun TextView.setDrawable(lDrawable: Drawable?, rDrawable: Drawable?, lIconWidth: Float? = null, lIconHeight: Float? = null, rIconWidth: Float? = null, rIconHeight: Float? = null) {
    if (lIconWidth != null && lIconHeight != null) {
        lDrawable?.setBounds(0,0, dp2px(lIconWidth), dp2px(lIconHeight))
    }
    if (rIconWidth != null && rIconHeight != null) {
        rDrawable?.setBounds(0,0, dp2px(rIconWidth), dp2px(rIconHeight))
    }
    setCompoundDrawables(lDrawable, null, rDrawable, null)
}