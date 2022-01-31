package com.agentrediska.hardwarestore.presentation.precategoryfragment.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agentrediska.hardwarestore.R
import com.agentrediska.hardwarestore.databinding.HolderForListItemBinding
import com.agentrediska.hardwarestore.domain.model.PreCategory

class PreCategoryAdapter: RecyclerView.Adapter<PreCategoryAdapter.PreCategoryHolder>() {
    val preCategoryList = ArrayList<PreCategory>()

    class PreCategoryHolder( item: View) : RecyclerView.ViewHolder( item){
        private val binding = HolderForListItemBinding.bind( item)

        fun bind( preCategory: PreCategory) = with( binding) {
            nameCategoryText.text = preCategory.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreCategoryHolder {
        val view = LayoutInflater.from( parent.context)
            .inflate(R.layout.holder_for_list_item, parent, false)
        return PreCategoryHolder( view)
    }

    override fun onBindViewHolder(holder: PreCategoryHolder, position: Int) {
        holder.bind( preCategory = preCategoryList[position])
    }

    override fun getItemCount(): Int {
        return preCategoryList.size
    }
}