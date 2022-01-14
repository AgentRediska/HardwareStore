package com.agentrediska.hardwarestore.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.usecase.GetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.GetCategorySharedPrefUseCase
import com.agentrediska.hardwarestore.domain.usecase.SetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.SetCategorySharedPrefUseCase


class CategoriesViewModel(
    private val setCategorySharedPrefUseCase: SetCategorySharedPrefUseCase,
    private val getCategorySharedPrefUseCase: GetCategorySharedPrefUseCase,
    private val setCategorySQLiteUseCase: SetCategorySQLiteUseCase,
    private val getCategorySQLiteUseCase: GetCategorySQLiteUseCase,
) : ViewModel() {

    private val categoryInfoLiveData = MutableLiveData<Category>()
    val categoryInfoLive: LiveData<Category> = categoryInfoLiveData
    private val correctNewInfoLiveData = MutableLiveData<Boolean>()
    val correctNewInfoLive: LiveData<Boolean> = correctNewInfoLiveData

    fun setCategory(idCategory: String, nameCategory: String) {
        val newCategory = Category(id = idCategory.toInt(), name = nameCategory)
        val result = setCategorySharedPrefUseCase.setCategory(newCategory)
        correctNewInfoLiveData.value = result
    }

    fun getCategory() {
        categoryInfoLiveData.value = getCategorySharedPrefUseCase.getCategory()
    }

}