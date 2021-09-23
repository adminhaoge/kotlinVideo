@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.hazz.kotlinmvp.ui.holder

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eyepetizer.android.logic.model.VideoRelated
import com.eyepetizer.android.logic.model.VideoReplies
import com.hazz.kotlinmvp.Constants.ViewHolderType.AUTO_PLAY_VIDEO_AD
import com.hazz.kotlinmvp.Constants.ViewHolderType.BANNER
import com.hazz.kotlinmvp.Constants.ViewHolderType.BANNER3
import com.hazz.kotlinmvp.Constants.ViewHolderType.COLUMN_CARD_LIST
import com.hazz.kotlinmvp.Constants.ViewHolderType.FOLLOW_CARD
import com.hazz.kotlinmvp.Constants.ViewHolderType.HORIZONTAL_SCROLL_CARD
import com.hazz.kotlinmvp.Constants.ViewHolderType.INFORMATION_CARD
import com.hazz.kotlinmvp.Constants.ViewHolderType.SPECIAL_SQUARE_CARD_COLLECTION
import com.hazz.kotlinmvp.Constants.ViewHolderType.TAG_BRIEFCARD
import com.hazz.kotlinmvp.Constants.ViewHolderType.TEXT_CARD_FOOTER2
import com.hazz.kotlinmvp.Constants.ViewHolderType.TEXT_CARD_FOOTER3
import com.hazz.kotlinmvp.Constants.ViewHolderType.TEXT_CARD_HEADER4
import com.hazz.kotlinmvp.Constants.ViewHolderType.TEXT_CARD_HEADER5
import com.hazz.kotlinmvp.Constants.ViewHolderType.TEXT_CARD_HEADER7
import com.hazz.kotlinmvp.Constants.ViewHolderType.TEXT_CARD_HEADER8
import com.hazz.kotlinmvp.Constants.ViewHolderType.TOPIC_BRIEFCARD
import com.hazz.kotlinmvp.Constants.ViewHolderType.UGC_SELECTED_CARD_COLLECTION
import com.hazz.kotlinmvp.Constants.ViewHolderType.UNKNOWN
import com.hazz.kotlinmvp.Constants.ViewHolderType.VIDEO_SMALL_CARD
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.extension.inflate
import com.hazz.kotlinmvp.mvp.model.bean.*

/**
 * 项目通用ViewHolder，集中统一管理。
 *
 * @author xuzhonghao
 * @since  2021/9/22
 */

/**
 * 未知类型，占位进行容错处理。
 */
class EmptyViewHolder(view: View) : RecyclerView.ViewHolder(view)

class TextCardViewFooter2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvFooterRightText2 = view.findViewById<TextView>(R.id.tvFooterRightText2)
    val ivTooterInto2 = view.findViewById<ImageView>(R.id.ivTooterInto2)
}

class TextCardViewFooter3ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvRefresh = view.findViewById<TextView>(R.id.tvRefresh)
    val tvFooterRightText3 = view.findViewById<TextView>(R.id.tvFooterRightText3)
    val ivTooterInto3 = view.findViewById<ImageView>(R.id.ivTooterInto3)
}

class TextCardViewHeader4ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle4 = view.findViewById<TextView>(R.id.tvTitle4)
    val ivInto4 = view.findViewById<ImageView>(R.id.ivInto4)
}

class TextCardViewHeader5ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle5 = view.findViewById<TextView>(R.id.tvTitle5)
    val tvFollow = view.findViewById<TextView>(R.id.tvFollow)
    val ivInto5 = view.findViewById<ImageView>(R.id.ivInto5)
}

class TextCardViewHeader7ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle7 = view.findViewById<TextView>(R.id.tvTitle7)
    val tvRightText7 = view.findViewById<TextView>(R.id.tvRightText7)
    val ivInto7 = view.findViewById<ImageView>(R.id.ivInto7)
}

class TextCardViewHeader8ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvTitle8 = view.findViewById<TextView>(R.id.tvTitle8)
    val tvRightText8 = view.findViewById<TextView>(R.id.tvRightText8)
    val ivInto8 = view.findViewById<ImageView>(R.id.ivInto8)
}

/**
 * RecyclerView帮助类，获取通用ViewHolder或ItemViewType。
 */
object RecyclerViewHelp {
    fun getViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {

        TEXT_CARD_FOOTER2 -> TextCardViewFooter2ViewHolder(R.layout.item_text_card_type_footer_two.inflate(parent))
        TEXT_CARD_FOOTER3 -> TextCardViewFooter3ViewHolder(R.layout.item_text_card_type_footer_three.inflate(parent))
        TEXT_CARD_HEADER4 -> TextCardViewHeader4ViewHolder(R.layout.item_text_card_type_header_four.inflate(parent))
        TEXT_CARD_HEADER5 -> TextCardViewHeader5ViewHolder(R.layout.item_text_card_type_header_five.inflate(parent))
        TEXT_CARD_HEADER7 -> TextCardViewHeader7ViewHolder(R.layout.item_text_card_type_header_seven.inflate(parent))
        TEXT_CARD_HEADER8 -> TextCardViewHeader8ViewHolder(R.layout.item_text_card_type_header_eight.inflate(parent))
        else -> EmptyViewHolder(View(parent.context))
    }

    fun getItemViewType(type: String, dataType: String) = when (type) {
        "horizontalScrollCard" -> {
            when (dataType) {
                "HorizontalScrollCard" -> HORIZONTAL_SCROLL_CARD
                else -> UNKNOWN
            }
        }
        "specialSquareCardCollection" -> {
            when (dataType) {
                "ItemCollection" -> SPECIAL_SQUARE_CARD_COLLECTION
                else -> UNKNOWN
            }
        }
        "columnCardList" -> {
            when (dataType) {
                "ItemCollection" -> COLUMN_CARD_LIST
                else -> UNKNOWN
            }
        }
        "banner" -> {
            when (dataType) {
                "Banner" -> BANNER
                else -> UNKNOWN
            }
        }
        "banner3" -> {
            when (dataType) {
                "Banner" -> BANNER3
                else -> UNKNOWN
            }
        }
        "videoSmallCard" -> {
            when (dataType) {
                "VideoBeanForClient" -> VIDEO_SMALL_CARD
                else -> UNKNOWN
            }
        }
        "briefCard" -> {
            when (dataType) {
                "TagBriefCard" -> TAG_BRIEFCARD
                "TopicBriefCard" -> TOPIC_BRIEFCARD
                else -> UNKNOWN
            }
        }
        "followCard" -> {
            when (dataType) {
                "FollowCard" -> FOLLOW_CARD
                else -> UNKNOWN
            }
        }
        "informationCard" -> {
            when (dataType) {
                "InformationCard" -> INFORMATION_CARD
                else -> UNKNOWN
            }
        }
        "ugcSelectedCardCollection" -> {
            when (dataType) {
                "ItemCollection" -> UGC_SELECTED_CARD_COLLECTION
                else -> UNKNOWN
            }
        }
        "autoPlayVideoAd" -> {
            when (dataType) {
                "AutoPlayVideoAdDetail" -> AUTO_PLAY_VIDEO_AD
                else -> UNKNOWN
            }
        }
        else -> UNKNOWN
    }

    private fun getTextCardType(type: String) = when (type) {
        "header4" -> TEXT_CARD_HEADER4
        "header5" -> TEXT_CARD_HEADER5
        "header7" -> TEXT_CARD_HEADER7
        "header8" -> TEXT_CARD_HEADER8
        "footer2" -> TEXT_CARD_FOOTER2
        "footer3" -> TEXT_CARD_FOOTER3
        else -> UNKNOWN
    }

    fun getItemViewType(item: DetailsBean.Item): Int {
        return if (item.type == "textCard") getTextCardType(item.data.type) else getItemViewType(item.type, item.data.dataType)
    }

    fun getItemViewType(item: HomePageRecommendBean.Item): Int {
        return if (item.type == "textCard") getTextCardType(item.data.type) else getItemViewType(item.type, item.data.dataType)
    }

    fun getItemViewType(item: DailyBean.Item): Int {
        return if (item.type == "textCard") getTextCardType(item.data.type) else getItemViewType(item.type, item.data.dataType)
    }

    fun getItemViewType(item: FollowBean.Item): Int {
        return if (item.type == "textCard") getTextCardType(item.data.type) else getItemViewType(item.type, item.data.dataType)
    }

    fun getItemViewType(item: VideoRelated.Item): Int {
        return if (item.type == "textCard") getTextCardType(item.data.type) else getItemViewType(item.type, item.data.dataType)
    }

    fun getItemViewType(item: VideoReplies.Item): Int {
        return if (item.type == "textCard") getTextCardType(item.data.type) else getItemViewType(item.type, item.data.dataType)
    }
}


