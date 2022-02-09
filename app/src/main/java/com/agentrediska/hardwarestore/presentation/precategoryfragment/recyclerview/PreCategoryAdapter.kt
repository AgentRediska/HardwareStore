package com.agentrediska.hardwarestore.presentation.precategoryfragment.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.databinding.HolderForListItemBinding
import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.model.PreCategory

class PreCategoryAdapter(
    private val onClickCallback: ( id: Int, name: String) -> Unit
    ): RecyclerView.Adapter<PreCategoryHolder>() {

    private val _preCategoryList = mutableListOf<PreCategory>()
    private val preCategoryList: List<PreCategory> get() = _preCategoryList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreCategoryHolder {
        val view = LayoutInflater.from( parent.context)
            .inflate(R.layout.holder_for_list_item, parent, false)
        return PreCategoryHolder( view, onClickCallback)
    }

    override fun onBindViewHolder(holder: PreCategoryHolder, position: Int) {
        holder.bind( preCategory = preCategoryList[position])
    }

    override fun getItemCount(): Int {
        return preCategoryList.size
    }

    fun replacePreCategoriesList( newPreCategoryList: List<PreCategory>) {
        _preCategoryList.clear()
        _preCategoryList.addAll( newPreCategoryList)
        notifyDataSetChanged()
    }
}