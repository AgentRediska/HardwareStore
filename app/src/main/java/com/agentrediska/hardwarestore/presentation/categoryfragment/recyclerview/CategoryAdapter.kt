package com.agentrediska.hardwarestore.presentation.categoryfragment.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.databinding.CategoryItemBinding
import com.agentrediska.hardwarestore.domain.model.Category

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {
    val categoryList = ArrayList<Category>()

    class CategoryHolder( item: View): RecyclerView.ViewHolder( item) {
        private val binding = CategoryItemBinding.bind(item)
        fun bind( category: Category) = with(binding){
            nameCategoryText.text = category.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)

        return CategoryHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun addAllCategory( allCategoryList: List<Category>) {
        categoryList.clear()
        categoryList.addAll(allCategoryList)
        notifyDataSetChanged()
    }
}