package com.classic.common

import android.app.ActionBar
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout

class MultipleStatusView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val TAG = this.javaClass.canonicalName

    private val DEFAULT_LAYOUT_PARAMS : LayoutParams = LayoutParams(
        LayoutParams.MATCH_PARENT,
        LayoutParams.MATCH_PARENT
    )

    val STATUS_CONTENT : Int = 0x00
    val STATUS_LOADING : Int = 0x01
    val STATUS_EMPTY : Int = 0x02
    val STATUS_ERROR : Int = 0x03
    val STATUS_NO_NETWORK : Int = 0x04

    val NULL_RESOURCE_ID : Int = -1

    private var mViewStatus : Int = 0

    private var mEmptyView: View? = null
    private var mErrorView: View? = null
    private var mLoadingView: View? = null
    private var mNoNetworkView: View? = null
    private var mContentView: View? = null
    private var mEmptyViewResId = 0
    private var mErrorViewResId = 0
    private var mLoadingViewResId = 0
    private var mNoNetworkViewResId = 0
    private var mContentViewResId = 0
    private var mInflater: LayoutInflater? = null

    private var mOnRetryClickListener: OnClickListener? = null

    private val mOtherIds : ArrayList<Int> = ArrayList()

    init {
        val a : TypedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.MultipleStatusView,
            defStyleAttr,
            0
        )
        mEmptyViewResId = a.getResourceId(
            R.styleable.MultipleStatusView_emptyView,
            R.layout.empty_view
        )
        mErrorViewResId = a.getResourceId(
            R.styleable.MultipleStatusView_errorView,
            R.layout.error_view
        )
        mLoadingViewResId = a.getResourceId(
            R.styleable.MultipleStatusView_loadingView,
            R.layout.loading_view
        )
        mNoNetworkViewResId = a.getResourceId(
            R.styleable.MultipleStatusView_noNetworkView,
            R.layout.no_network_view
        )
        mContentViewResId = a.getResourceId(
            R.styleable.MultipleStatusView_contentView,
            NULL_RESOURCE_ID
        )
        a.recycle()
        mInflater = LayoutInflater.from(getContext())
    }


    override fun onFinishInflate() {
        super.onFinishInflate()
        showContent()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        clear(mEmptyView, mLoadingView, mErrorView, mNoNetworkView)
        mOtherIds?.clear()
        if (null != mOnRetryClickListener) {
            mOnRetryClickListener = null
        }
        mInflater = null
    }

    /**
     * 获取当前状态
     */
    fun getViewStatus(): Int {
        return mViewStatus
    }

    /**
     * 设置重试点击事件
     *
     * @param onRetryClickListener 重试点击事件
     */
    fun setOnRetryClickListener(onRetryClickListener: OnClickListener) {
        this.mOnRetryClickListener =onRetryClickListener
    }

    /**
     * 显示空视图
     */
    fun showEmpty() {
        showEmpty(mEmptyViewResId, DEFAULT_LAYOUT_PARAMS)
    }

    fun showEmpty(emptyViewResId: Int, defaultLayoutParams: LayoutParams) {
        showEmpty(inflateView(emptyViewResId), defaultLayoutParams)
    }

    fun showEmpty(emptyView: View?, defaultLayoutParams: LayoutParams) {
        mViewStatus = STATUS_EMPTY
        if (mEmptyView == null) {
            mEmptyView = emptyView
            mEmptyView?.let {
                val emptyRetryView = it.findViewById<View>(R.id.empty_retry_view)
                if (null != mOnRetryClickListener && null != emptyRetryView) {
                    emptyRetryView.setOnClickListener(mOnRetryClickListener)
                }
                mOtherIds.add(it.id)
                addView(it, 0, defaultLayoutParams)
            }
        }
        showViewById(mEmptyView?.id)
    }

    private fun showViewById(id: Int?) {
        val childCount = childCount
        for (child in 0 until childCount) {
            val view = getChildAt(child)
            view?.let {
                it.visibility = if (view.id == id) View.VISIBLE else View.GONE
            }
        }
    }


    /**
     * 显示错误视图
     */
    fun showError() {
        showError(mErrorViewResId, DEFAULT_LAYOUT_PARAMS)
    }

    fun showError(errorViewResId: Int, defaultLayoutParams: LayoutParams) {
        showError(inflateView(errorViewResId), defaultLayoutParams)
    }

    fun showError(errorView: View?, defaultLayoutParams: LayoutParams) {
        mViewStatus = STATUS_ERROR
        if (null == mErrorView) {
            mErrorView = errorView
            mErrorView?.let {
                val errorRetryView = it.findViewById<View>(R.id.error_retry_view)
                if (null != mOnRetryClickListener && null != errorRetryView) {
                    errorRetryView.setOnClickListener(mOnRetryClickListener)
                }
                mOtherIds.add(it.id)
                addView(it, 0, defaultLayoutParams)
            }
        }
        showViewById(mErrorView?.id)

    }


    /**
     * 显示加载中视图
     */
    fun showLoading(){
        showLoading(mLoadingViewResId, DEFAULT_LAYOUT_PARAMS)
    }

    fun showLoading(loadingViewResId: Int, defaultLayoutParams: LayoutParams) {
        showLoading(inflateView(loadingViewResId), defaultLayoutParams)
    }

    fun showLoading(loadingView: View?, defaultLayoutParams: LayoutParams) {
        mViewStatus = STATUS_LOADING
        if (null == mLoadingView) {
            mLoadingView = loadingView
            mLoadingView?.let {
                mOtherIds.add(it.id)
                addView(it, 0, defaultLayoutParams)
            }
        }
        showViewById(mLoadingView?.id)
    }


    /**
     * 显示无网络视图
     */
    fun showNoNetwork() {
        showNoNetwork(mNoNetworkViewResId, DEFAULT_LAYOUT_PARAMS)
    }

    fun showNoNetwork(noNetworkViewResId: Int, defaultLayoutParams: LayoutParams) {
        showNoNetwork(inflateView(noNetworkViewResId), defaultLayoutParams)
    }

    fun showNoNetwork(noNetworkView: View?, defaultLayoutParams: LayoutParams) {
        mViewStatus = STATUS_NO_NETWORK
        if (mNoNetworkView == null) {
            mNoNetworkView = noNetworkView
            mNoNetworkView?.let {
                val noDefaultNetworkView = it.findViewById<View>(R.id.no_network_view)
                if (null != mOnRetryClickListener && null != noNetworkView) {
                    noDefaultNetworkView.setOnClickListener(mOnRetryClickListener)
                }
                mOtherIds.add(it.id)
                addView(it, 0, defaultLayoutParams)
            }
        }
        showViewById(mNoNetworkView!!.id)
    }

    private fun inflateView(layoutView: Int) : View? {
        return mInflater?.inflate(layoutView, null)
    }

    private fun clear(vararg views: View?) {
        views.let {
            for (view in views) {
                removeView(view)
            }
        }
    }

     fun showContent() {
        mViewStatus = STATUS_CONTENT
        if (null == mContentView && mContentViewResId != NULL_RESOURCE_ID) {
            mContentView = mInflater?.let { it.inflate(mContentViewResId, null) }
            addView(mContentView, 0, DEFAULT_LAYOUT_PARAMS)
        }
        showContentView()
    }

    private fun showContentView() {
        val childCount = childCount
        for (child in 0 until childCount) {
            val view = getChildAt(child)
            view?.let {
                it.visibility = if (mOtherIds.contains(view.id)) View.GONE else View.VISIBLE
            }
        }
    }
}