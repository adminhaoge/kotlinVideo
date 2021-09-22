package com.hazz.kotlinmvp

//  ┏┓　　　┏┓
//┏┛┻━━━┛┻┓
//┃　　　　　　　┃
//┃　　　━　　　┃
//┃　┳┛　┗┳　┃
//┃　　　　　　　┃
//┃　　　┻　　　┃
//┃　　　　　　　┃
//┗━┓　　　┏━┛
//    ┃　　　┃   神兽保佑
//    ┃　　　┃   代码无BUG！
//    ┃　　　┗━━━┓
//    ┃　　　　　　　┣┓
//    ┃　　　　　　　┏┛
//    ┗┓┓┏━┳┓┏┛
//      ┃┫┫　┃┫┫
//      ┗┻┛　┗┻┛
/**
 * Created by xuhao on 2017/11/27.
 * desc: 常量
 */
class Constants private constructor() {

    companion object {

        val BUNDLE_VIDEO_DATA = "video_data"
        val BUNDLE_CATEGORY_DATA = "category_data"

        //腾讯 Bugly APP id
        val BUGLY_APPID = "176aad0d9e"


        //sp 存储的文件名
        val FILE_WATCH_HISTORY_NAME = "watch_history_file"   //观看记录

        val FILE_COLLECTION_NAME = "collection_file"    //收藏视屏缓存的文件名
    }

    object Mobclick {
        val UMENG_EVENT1 = "1001"
        val UMENG_EVENT2 = "1002"
    }

    object ViewHolderType{
        const val UNKNOWN = -1
        const val CUSTOM_HEADER = 0
        const val TEXT_CARD_HEADER0 = 1
        const val TEXT_CARE_HEADER = 2
        const val TEXT_CARD_HEADER3 = 3
        const val TEXT_CARD_HEADER4 = 4
        const val TEXT_CARD_HEADER5 = 5     //type:textCard -> dataType:TextCard -> type:header5

        const val TEXT_CARD_HEADER6 = 6

        const val TEXT_CARD_HEADER7 = 7    //type:textCard -> dataType:TextCardWithRightAndLeftTitle,type:header7

        const val TEXT_CARD_HEADER8 = 8    //type:textCard -> dataType:TextCardWithRightAndLeftTitle,type:header8

        const val TEXT_CARD_FOOTER1 = 9

        const val TEXT_CARD_FOOTER2 = 10    //type:textCard -> dataType:TextCard,type:footer2

        const val TEXT_CARD_FOOTER3 = 11    //type:textCard -> dataType:TextCardWithTagId,type:footer3

        const val BANNER = 12               //type:banner -> dataType:Banner

        const val BANNER3 = 13              //type:banner3-> dataType:Banner

        const val FOLLOW_CARD = 14          //type:followCard -> dataType:FollowCard -> type:video -> dataType:VideoBeanForClient

        const val TAG_BRIEFCARD = 15        //type:briefCard -> dataType:TagBriefCard

        const val TOPIC_BRIEFCARD = 16      //type:briefCard -> dataType:TopicBriefCard

        const val COLUMN_CARD_LIST = 17      //type:columnCardList -> dataType:ItemCollection

        const val VIDEO_SMALL_CARD = 18     //type:videoSmallCard -> dataType:VideoBeanForClient

        const val INFORMATION_CARD = 19     //type:informationCard -> dataType:InformationCard

        const val AUTO_PLAY_VIDEO_AD = 20   //type:autoPlayVideoAd -> dataType:AutoPlayVideoAdDetail

        const val HORIZONTAL_SCROLL_CARD = 21    //type:horizontalScrollCard -> dataType:HorizontalScrollCard

        const val SPECIAL_SQUARE_CARD_COLLECTION = 22   //type:specialSquareCardCollection -> dataType:ItemCollection

        const val UGC_SELECTED_CARD_COLLECTION = 23   //type:ugcSelectedCardCollection -> dataType:ItemCollection

        const val MAX = 100   //避免外部其他类型与此处包含的某个类型重复。

    }

}