package com.example.chaintask.screens.main.ui.home

import android.view.View
import com.example.chaintask.common.BaseViewHolder
import com.example.chaintask.databinding.ItemMostPopulerBinding
import com.example.chaintask.extensions.toViewClickListener
import com.example.domain.model.home.MostPopular

class MostPopularViewHolder(private val item: ItemMostPopulerBinding) : BaseViewHolder<MostPopular>(item) {

    override fun bind(
        model: MostPopular, position: Int, clickListener: ((view: View, model: MostPopular, position: Int) -> Unit)?
    ) {
        item.mostPopular = model
        item.clickListener = clickListener.toViewClickListener(model, position)
    }
}