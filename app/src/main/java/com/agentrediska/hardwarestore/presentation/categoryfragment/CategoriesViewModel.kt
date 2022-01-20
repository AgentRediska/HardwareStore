package com.agentrediska.hardwarestore.presentation.categoryfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.usecase.*
import kotlinx.coroutines.*


class CategoriesViewModel(

    private val setCategorySQLiteUseCase: SetCategorySQLiteUseCase,
    private val getCategorySQLiteUseCase: GetCategorySQLiteUseCase,
    private val getAllCategorySQLiteUseCase: GetAllCategoryUseCase
) : ViewModel() {

    private val TAG = "MyApp"

    private val categoryInfoLiveData = MutableLiveData<Category>()
    val categoryInfoLive: LiveData<Category> = categoryInfoLiveData
    private val allCategoryLiveData = MutableLiveData<List<Category>>()
    val allCategoryLive: LiveData<List<Category>> = allCategoryLiveData
    private val correctNewInfoLiveData = MutableLiveData<Boolean>()
    val correctNewInfoLive: LiveData<Boolean> = correctNewInfoLiveData

    fun setCategoryToSQLite( idCategory: String, nameCategory: String) {
        viewModelScope.launch {
            val result = setCategorySQLiteUseCase.setCategory( createNewCategory(idCategory, nameCategory) )
            correctNewInfoLiveData.value = result
        }
    }

    fun getCategoryFromSQLite() {
        viewModelScope.launch {
            categoryInfoLiveData.value = getCategorySQLiteUseCase.getCategory()
        }
    }

    fun getAllCategoryFromSQLite() {
        viewModelScope.launch {
            allCategoryLiveData.value = getAllCategorySQLiteUseCase.getAllCategories()
        }
    }

    private fun createNewCategory( idCategory: String, nameCategory: String) : Category {
        return Category(id = idCategory.toInt(), name = nameCategory)
    }

}