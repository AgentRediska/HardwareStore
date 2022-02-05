package com.agentrediska.hardwarestore.presentation.precategoryfragment.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.agentrediska.hardwarestore.databinding.HolderForListItemBinding
import com.agentrediska.hardwarestore.domain.model.PreCategory

class PreCategoryHolder( item: View) : RecyclerView.ViewHolder( item){
    private val binding = HolderForListItemBinding.bind( item)

    fun bind( preCategory: PreCategory) = with( binding) {
        nameCategoryText.text = preCategory.name
    }
}