package com.hazz.kotlinmvp.mvp.contract

import com.hazz.kotlinmvp.base.IBaseView
import com.hazz.kotlinmvp.mvp.model.bean.DetailsBean
import com.hazz.kotlinmvp.mvp.model.bean.HomeBean

interface DetailsContract {

    interface View : IBaseView {

        /**
         * 设置第一次请求的数据
         */
        fun responseHomeData(detail: DetailsBean)


        /**
         * 显示错误信息
         */
        fun responseError(msg: String,errorCode:Int)

    }


    interface Presenter {

        /**
         * 获取首页精选数据
         */
        fun requestHomeData()

    }

}