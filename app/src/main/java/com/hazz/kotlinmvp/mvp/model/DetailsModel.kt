package com.hazz.kotlinmvp.mvp.model

import com.hazz.kotlinmvp.mvp.model.bean.DetailsBean
import com.hazz.kotlinmvp.mvp.model.bean.HomeBean
import com.hazz.kotlinmvp.net.RetrofitManager
import com.hazz.kotlinmvp.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

class DetailsModel {

    /**
     * 获取首页 Banner 数据
     */
    fun requestDetailsData(): Observable<DetailsBean> {
        return RetrofitManager.service.getDetailData()
                .compose(SchedulerUtils.ioToMain())
    }

}