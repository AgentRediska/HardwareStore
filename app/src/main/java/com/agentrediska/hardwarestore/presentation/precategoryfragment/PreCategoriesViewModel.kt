package com.agentrediska.hardwarestore.presentation.precategoryfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agentrediska.hardwarestore.domain.model.PreCategory
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.GetAllPreCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.SetPreCategorySQLiteUseCase
import kotlinx.coroutines.launch

class PreCategoriesViewModel(
    private val getAllPreCategorySQLiteUseCase: GetAllPreCategorySQLiteUseCase,
    private val setPreCategorySQLiteUseCase: SetPreCategorySQLiteUseCase
) : ViewModel() {

    private val allPreCategoryLiveData = MutableLiveData<List<PreCategory>>()
    val allPreCategoryLD: LiveData<List<PreCategory>> = allPreCategoryLiveData

     fun setPreCategory( preCategory: PreCategory) {
        viewModelScope.launch {
          setPreCategorySQLiteUseCase.setPreCategory( preCategory = preCategory)
        }
    }

    fun getPreCategoriesByCategoryId( categoryId: Int) {
        viewModelScope.launch {
            allPreCategoryLiveData.value =
                getAllPreCategorySQLiteUseCase.getAllPreCategoryByCategoryId( categoryId = categoryId)
        }
    }

}