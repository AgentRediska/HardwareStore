package com.agentrediska.hardwarestore.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agentrediska.hardwarestore.data.repository.AllCategoryRepositoryImp
import com.agentrediska.hardwarestore.data.repository.CategoryRepositoryImp
import com.agentrediska.hardwarestore.data.storage.SharedPreferenceStorage
import com.agentrediska.hardwarestore.domain.usecase.GetAllCategoriesUseCase
import com.agentrediska.hardwarestore.domain.usecase.GetCategoryUseCase
import com.agentrediska.hardwarestore.domain.usecase.SetCategoryUseCase

class CategoriesViewModelFactory( context: Context) : ViewModelProvider.Factory {

    private val categoryRepository by lazy {
        CategoryRepositoryImp(SharedPreferenceStorage(context = context) )
    }

    private val allCategoryRepository by lazy {
        AllCategoryRepositoryImp( context = context )
    }

    private val getCategoryUseCase by lazy {
        GetCategoryUseCase(categoryRepository = categoryRepository)
    }

    private val setCategoryUseCase by lazy {
        SetCategoryUseCase(categoryRepository = categoryRepository)
    }

    private val getAllCategoriesUseCase by lazy {
        GetAllCategoriesUseCase(allCategoryRepository = allCategoryRepository)
    }


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoriesViewModel(
            setCategoryUseCase = setCategoryUseCase,
            getCategoryUseCase = getCategoryUseCase) as T
    }
}