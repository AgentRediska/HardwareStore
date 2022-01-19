package com.agentrediska.hardwarestore.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.usecase.GetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.GetCategorySharedPrefUseCase
import com.agentrediska.hardwarestore.domain.usecase.SetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.SetCategorySharedPrefUseCase
import kotlinx.coroutines.*


class CategoriesViewModel(
    private val setCategorySharedPrefUseCase: SetCategorySharedPrefUseCase,
    private val getCategorySharedPrefUseCase: GetCategorySharedPrefUseCase,
    private val setCategorySQLiteUseCase: SetCategorySQLiteUseCase,
    private val getCategorySQLiteUseCase: GetCategorySQLiteUseCase,
) : ViewModel() {


    private val TAG = "MyApp"

    private val categoryInfoLiveData = MutableLiveData<Category>()
    val categoryInfoLive: LiveData<Category> = categoryInfoLiveData
    private val correctNewInfoLiveData = MutableLiveData<Boolean>()
    val correctNewInfoLive: LiveData<Boolean> = correctNewInfoLiveData

    fun setCategory( idCategory: String, nameCategory: String) {
        val result = setCategorySharedPrefUseCase.setCategory( createNewCategory(idCategory, nameCategory) )
        correctNewInfoLiveData.value = result
    }

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


    private fun createNewCategory( idCategory: String, nameCategory: String) : Category {
        return Category(id = idCategory.toInt(), name = nameCategory)
    }

    fun getCategory() {
        categoryInfoLiveData.value = getCategorySharedPrefUseCase.getCategory()
        //categoryInfoLiveData.value = getCategorySQLiteUseCase.getCategory()

    }

}