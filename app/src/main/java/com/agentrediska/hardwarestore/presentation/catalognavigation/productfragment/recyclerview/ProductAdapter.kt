package com.agentrediska.hardwarestore.presentation.catalognavigation.productfragment.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.domain.model.Product

class ProductAdapter(
    private val onClickCallBack: (productId: Int) -> Unit
): RecyclerView.Adapter<ProductHolder>() {

    private val _productsList = mutableListOf<Product>()
    private val productsList: List<Product> get() = _productsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_for_list_item, parent, false)
        return ProductHolder( view, onClickCallBack)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind( product = productsList[position])
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    fun replaceProductsList( newProductsList: List<Product>) {
        _productsList.clear()
        _productsList.addAll( newProductsList)
        notifyDataSetChanged()
    }
}