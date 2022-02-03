package com.agentrediska.hardwarestore.presentation.categoryfragment.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.databinding.HolderForListItemBinding
import com.agentrediska.hardwarestore.domain.model.Category

class CategoryAdapter(
    private val onClickCallback: ( id: Int, name: String) -> Unit
    ): RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    private var categoryList = mutableListOf<Category>()

    class CategoryHolder( item: View,
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.holder_for_list_item, parent, false)

        return CategoryHolder(view, onClickCallback)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun replaceCategoriesList( newCategoryList: List<Category>) {
        categoryList.clear()
        categoryList.addAll( newCategoryList)
        notifyDataSetChanged()
    }

}