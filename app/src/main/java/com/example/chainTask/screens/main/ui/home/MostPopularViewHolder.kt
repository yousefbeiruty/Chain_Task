package com.example.chainTask.screens.main.ui.home

import android.view.View
import com.example.chainTask.common.BaseViewHolder
import com.example.chainTask.databinding.ItemMostPopulerBinding
import com.example.chainTask.extensions.toViewClickListener
import com.example.domain.model.home.MostPopular

class MostPopularViewHolder(private val item: ItemMostPopulerBinding) : BaseViewHolder<MostPopular>(item) {

    override fun bind(
        model: MostPopular, position: Int, clickListener: ((view: View, model: MostPopular, position: Int) -> Unit)?
    ) {
        item.mostPopular = model
        item.clickListener = clickListener.toViewClickListener(model, position)
    }
}