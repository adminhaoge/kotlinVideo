package com.hazz.kotlinmvp.mvp.presenter

import com.hazz.kotlinmvp.base.BasePresenter
import com.hazz.kotlinmvp.mvp.contract.DetailsContract
import com.hazz.kotlinmvp.mvp.model.DetailsModel
import com.hazz.kotlinmvp.mvp.model.HomeModel
import com.hazz.kotlinmvp.mvp.model.bean.DetailsBean
import com.hazz.kotlinmvp.net.exception.ExceptionHandle

class DetailsPresenter: BasePresenter<DetailsContract.View>(), DetailsContract.Presenter {

    private val homeModel: DetailsModel by lazy {
        DetailsModel()
    }

    override fun requestHomeData() {
        // 检测是否绑定 View
        checkViewAttached()
        mRootView?.showLoading()
        val dispose = homeModel.requestDetailsData()
                .subscribe({detailsBean ->
                    mRootView?.apply {
                        dismissLoading()
                        responseHomeData(detailsBean)
                    }
                },{
                    error ->
                    mRootView?.apply {
                        responseError(ExceptionHandle.handleException(error),ExceptionHandle.errorCode)
                    }

                })

        addSubscription(dispose)
    }
}