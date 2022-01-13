package com.agentrediska.hardwarestore.presentation

import androidx.lifecycle.ViewModel
import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.usecase.GetAllCategoriesUseCase
import com.agentrediska.hardwarestore.domain.usecase.GetCategoryUseCase
import com.agentrediska.hardwarestore.domain.usecase.SetCategoryUseCase


class CategoriesViewModel(
    private val setCategoryUseCase: SetCategoryUseCase,
    private val getCategoryUseCase: GetCategoryUseCase
) : ViewModel() {

    fun setCategory(idCategory: String, nameCategory: String) : Boolean {
        val newCategory = Category(id = idCategory.toInt(), name = nameCategory)
        return setCategoryUseCase.setCategory(newCategory)
    }

    fun getCategory() : Category {
        return getCategoryUseCase.getCategory()
    }

}