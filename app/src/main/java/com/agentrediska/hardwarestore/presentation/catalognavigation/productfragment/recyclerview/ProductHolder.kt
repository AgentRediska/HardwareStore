package com.agentrediska.hardwarestore.presentation.catalognavigation.productfragment.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.agentrediska.hardwarestore.databinding.HolderForListItemBinding
import com.agentrediska.hardwarestore.domain.model.Product

class ProductHolder( item: View,
                    private val onClickCallBack: (productId: Int) -> Unit
) : RecyclerView.ViewHolder( item) {

    private val binding = HolderForListItemBinding.bind( item)

    fun bind( product: Product) = with( binding) {
        nameCategoryText.text = product.name

        cardView.setOnClickListener {
            onClickCallBack( product.id)
        }
    }
}