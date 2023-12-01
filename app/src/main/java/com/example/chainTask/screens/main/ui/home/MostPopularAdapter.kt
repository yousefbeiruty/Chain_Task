package com.example.chainTask.screens.main.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.example.chainTask.R
import com.example.chainTask.common.BaseListAdapter
import com.example.chainTask.common.BaseViewHolder
import com.example.chainTask.databinding.ItemMostPopulerBinding
import com.example.domain.model.home.MostPopular

class MostPopularAdapter : BaseListAdapter<BaseViewHolder<MostPopular>, MostPopular>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemMostPopulerBinding>(
            inflater, R.layout.item_most_populer, parent, false
        )
        return MostPopularViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<MostPopular>, position: Int) {
        holder.bind(getItem(position), position, getOnItemClickListener())
    }

    companion object {

        val DIFF_CALLBACK: DiffUtil.ItemCallback<MostPopular> =
            object : DiffUtil.ItemCallback<MostPopular>() {
                override fun areContentsTheSame(
                    oldItem: MostPopular,
                    newItem: MostPopular
                ): Boolean {
                    return oldItem.title == newItem.title
                }

                override fun areItemsTheSame(
                    oldItem: MostPopular,
                    newItem: MostPopular
                ): Boolean {
                    return oldItem.id == newItem.id
                }
            }
    }
}