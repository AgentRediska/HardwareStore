package com.agentrediska.hardwarestore.presentation.productfragment.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.agentrediska.hardwarestore.databinding.HolderForListItemBinding
import com.agentrediska.hardwarestore.domain.model.Product

class ProductHolder( item: View) : RecyclerView.ViewHolder( item) {

    private val binding = HolderForListItemBinding.bind( item)

    fun bind( product: Product) = with( binding) {
        nameCategoryText.text = product.name
    }
}