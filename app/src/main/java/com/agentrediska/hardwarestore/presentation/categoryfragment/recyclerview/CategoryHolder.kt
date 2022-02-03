package com.agentrediska.hardwarestore.presentation.categoryfragment.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.agentrediska.hardwarestore.databinding.HolderForListItemBinding
import com.agentrediska.hardwarestore.domain.model.Category

class CategoryHolder(item: View,
                     private val onClickCallback: (id: Int, name: String) -> Unit
): RecyclerView.ViewHolder( item) {

    private val binding = HolderForListItemBinding.bind(item)
    private lateinit var localeCategory: Category
    fun bind( category: Category) = with(binding){
        nameCategoryText.text = category.name
        localeCategory = category

        cardViewCategory.setOnClickListener {
            onClickCallback( localeCategory.id, localeCategory.name)
        }
    }
}