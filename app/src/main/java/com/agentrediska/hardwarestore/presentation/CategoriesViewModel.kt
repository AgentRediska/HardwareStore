package com.agentrediska.hardwarestore.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.usecase.GetAllCategoriesUseCase
import com.agentrediska.hardwarestore.domain.usecase.GetCategoryUseCase
import com.agentrediska.hardwarestore.domain.usecase.SetCategoryUseCase


class CategoriesViewModel(
    private val setCategoryUseCase: SetCategoryUseCase,
    private val getCategoryUseCase: GetCategoryUseCase,
) : ViewModel() {

    val categoryInfoLiveData = MutableLiveData<Category>()
    val correctNewInfoLiveData = MutableLiveData<Boolean>()

    fun setCategory(idCategory: String, nameCategory: String) {
        val newCategory = Category(id = idCategory.toInt(), name = nameCategory)
        val result = setCategoryUseCase.setCategory(newCategory)
        correctNewInfoLiveData.value = result
    }

    fun getCategory() {
        categoryInfoLiveData.value = getCategoryUseCase.getCategory()
    }

}