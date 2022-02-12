package com.agentrediska.hardwarestore.presentation.catalognavigation.categoryfragment.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.agentrediska.hardwarestore.databinding.HolderForListItemBinding
import com.agentrediska.hardwarestore.domain.model.Category

class CategoryHolder(item: View,
                     private val onClickCallback: (id: Int, name: String) -> Unit
): RecyclerView.ViewHolder( item) {

    private val binding = HolderForListItemBinding.bind(item)
    fun bind( category: Category) = with(binding){
        nameCategoryText.text = category.name

        cardView.setOnClickListener {
            onClickCallback( category.id, category.name)
        }
    }
}