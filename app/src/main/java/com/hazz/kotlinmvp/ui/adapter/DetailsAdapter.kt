package com.hazz.kotlinmvp.ui.adapter

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.extension.gone
import com.hazz.kotlinmvp.extension.setOnClickListener
import com.hazz.kotlinmvp.extension.showToast
import com.hazz.kotlinmvp.extension.visible
import com.hazz.kotlinmvp.mvp.model.bean.DetailsBean
import com.hazz.kotlinmvp.ui.fragment.DetailsFragment
import com.hazz.kotlinmvp.ui.holder.*
import com.hazz.kotlinmvp.utils.ActionUrlUtil
import com.hazz.kotlinmvp.utils.GlobalUtil

class DetailsAdapter(val fragment: DetailsFragment) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private lateinit var details: DetailsBean

    override fun getItemViewType(position: Int): Int = RecyclerViewHelp.getItemViewType(getItem(position)!!)

    private fun getItem(position: Int): DetailsBean.Item {
        return details.itemList[position]
    }

    fun obtainDetailsData(details : DetailsBean){
        this.details = details
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)!!
        when (holder) {
            is TextCardViewHeader5ViewHolder -> {
                holder.tvTitle5.text = item.data.text
                if (item.data.actionUrl != null) holder.ivInto5.visible() else holder.ivInto5.gone()
                if (item.data.follow != null) holder.tvFollow.visible() else holder.tvFollow.gone()
                holder.tvFollow.setOnClickListener {  }
                setOnClickListener(holder.tvTitle5, holder.ivInto5) {ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text)}
            }
            is TextCardViewHeader7ViewHolder -> {
                holder.tvTitle7.text = item.data.text
                holder.tvRightText7.text = item.data.rightText
                setOnClickListener(holder.tvRightText7, holder.ivInto7) {
                    ActionUrlUtil.process(fragment, item.data.actionUrl, "${item.data.text},${item.data.rightText}")
                }
            }
            is TextCardViewHeader8ViewHolder -> {
                holder.tvTitle8.text = item.data.text
                holder.tvRightText8.text = item.data.rightText
                setOnClickListener(holder.tvRightText8, holder.ivInto8) { ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text) }
            }
            is TextCardViewFooter2ViewHolder -> {
                holder.tvFooterRightText2.text = item.data.text
                setOnClickListener(holder.tvFooterRightText2, holder.ivTooterInto2) { ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text) }
            }
            is TextCardViewFooter3ViewHolder -> {
                holder.tvFooterRightText3.text = item.data.text
                setOnClickListener(holder.tvRefresh, holder.tvFooterRightText3, holder.ivTooterInto3) {
                    if (this == holder.tvRefresh) {
                        "${holder.tvRefresh.text},${GlobalUtil.getString(R.string.currently_not_supported)}".showToast()
                    } else if (this == holder.tvFooterRightText3 || this == holder.ivTooterInto3) {
                        ActionUrlUtil.process(fragment, item.data.actionUrl, item.data.text)
                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RecyclerViewHelp.getViewHolder(parent, viewType)

    override fun getItemCount(): Int {
        return if (details.count > 0) details.count else 0
    }

}

