package com.hazz.kotlinmvp.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hazz.kotlinmvp.R
import com.hazz.kotlinmvp.mvp.model.bean.DetailsBean
import com.hazz.kotlinmvp.ui.holder.RecyclerViewHelp
import com.hazz.kotlinmvp.ui.holder.TextCardViewFooter2ViewHolder
import com.hazz.kotlinmvp.ui.holder.TextCardViewHeader5ViewHolder

class DetailsAdapter : PagingDataAdapter<DetailsBean.Item, RecyclerView.ViewHolder>(DIFF_CALLBACK){

    override fun getItemViewType(position: Int): Int = RecyclerViewHelp.getItemViewType(getItem(position)!!)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)!!
        when (holder) {
            is TextCardViewHeader5ViewHolder -> {

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RecyclerViewHelp.getViewHolder(parent, viewType)




    companion object {
        const val TAG = "DetailsAdapter"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DetailsBean.Item>() {
            override fun areItemsTheSame(
                oldItem: DetailsBean.Item,
                newItem: DetailsBean.Item
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: DetailsBean.Item,
                newItem: DetailsBean.Item
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

}

