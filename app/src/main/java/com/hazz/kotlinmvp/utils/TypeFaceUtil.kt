package com.hazz.kotlinmvp.utils

import android.graphics.Typeface
import com.hazz.kotlinmvp.MyApplication

/**
 * 自定义字体工具类。
 *
 * @author xuzhonghao
 * @since  2021.9.16
 */
object TypeFaceUtil {
    const val FZLL_TYPEFACE = 1

    const val FZDB1_TYPEFACE = 2

    const val FUTURA_TYPEFACE = 3

    const val DIN_TYPEFACE = 4

    const val LOBSTER_TYPEFACE = 5

    private var fzlLTypeface: Typeface? = null

    private var fzdb1Typeface: Typeface? = null

    private var futuraTypeface: Typeface? = null

    private var dinTypeface: Typeface? = null

    private var lobsterTypeface: Typeface? = null

    fun getFzlLTypeface() = if(fzlLTypeface == null) {
        try {
            fzlLTypeface = Typeface.createFromAsset(MyApplication.context.assets, "fonts/FZLanTingHeiS-L-GB-Regular.TTF")
            fzlLTypeface
        } catch (e: RuntimeException) {
            Typeface.DEFAULT
        }
    } else {
        fzlLTypeface!!
    }

    fun getFzdb1Typeface() = if (fzdb1Typeface == null) {
        try {
            fzdb1Typeface = Typeface.createFromAsset(MyApplication.context.assets, "fonts/FZLanTingHeiS-DB1-GB-Regular.TTF")
            fzdb1Typeface
        } catch (e: RuntimeException) {
            Typeface.DEFAULT
        }
    } else {
        fzdb1Typeface!!
    }

    fun getFuturaTypeface() = if (futuraTypeface == null) {
        try {
            futuraTypeface = Typeface.createFromAsset(MyApplication.context.assets, "fonts/Futura-CondensedMedium.ttf")
            futuraTypeface
        } catch (e: RuntimeException) {
            Typeface.DEFAULT
        }
    } else {
        futuraTypeface!!
    }


    fun getDinTypeface() = if (dinTypeface == null) {
        try {
            dinTypeface = Typeface.createFromAsset(MyApplication.context.assets, "fonts/DIN-Condensed-Bold.ttf")
            dinTypeface
        } catch (e: RuntimeException) {
            Typeface.DEFAULT
        }

    } else {
        dinTypeface!!
    }

    fun getLobsterTypeface() = if (lobsterTypeface == null) {
        try {
            lobsterTypeface = Typeface.createFromAsset(MyApplication.context.assets,"fonts/Lobster-1.4.otf")
            lobsterTypeface
        }catch (e: RuntimeException) {
            Typeface.DEFAULT
        }
    } else {
        lobsterTypeface!!
    }

}