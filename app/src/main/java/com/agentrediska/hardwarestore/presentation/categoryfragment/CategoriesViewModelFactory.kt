package com.agentrediska.hardwarestore.presentation.categoryfragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agentrediska.hardwarestore.data.repository.CategoryRepositorySQLite
import com.agentrediska.hardwarestore.data.repository.CategoryRepositorySharedPref
import com.agentrediska.hardwarestore.data.storage.SharedPreferenceStorage
import com.agentrediska.hardwarestore.data.storage.database.LocalDatabaseRepository
import com.agentrediska.hardwarestore.domain.usecase.*

class CategoriesViewModelFactory( context: Context) : ViewModelProvider.Factory {

/*
    private val categorySharedPrefRepository by lazy {
        CategoryRepositorySharedPref(SharedPreferenceStorage(context = context) )
    }

    private val getCategorySharedPrefUseCase by lazy {
        GetCategorySharedPrefUseCase(iCategoryRepositorySharedPref = categorySharedPrefRepository)
    }

    private val setCategorySharedPrefUseCase by lazy {
        SetCategorySharedPrefUseCase( iCategoryRepositorySharedPref = categorySharedPrefRepository)
    }
*/
    private val categoryRepositoryLocalDatabase by lazy {
        CategoryRepositorySQLite(LocalDatabaseRepository.get())
    }

    private val getCategorySQLiteUseCase by lazy {
        GetCategorySQLiteUseCase(iCategoryRepositorySQLite = categoryRepositoryLocalDatabase)
    }

    private val getAllCategorySQLiteUseCase by lazy {
        GetAllCategoryUseCase( iCategoryRepositorySQLite = categoryRepositoryLocalDatabase)
    }

    private val setCategorySQLiteUseCase by lazy {
        SetCategorySQLiteUseCase(iCategoryRepositorySQLite = categoryRepositoryLocalDatabase)
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoriesViewModel(
            setCategorySQLiteUseCase = setCategorySQLiteUseCase,
            getCategorySQLiteUseCase = getCategorySQLiteUseCase,
            getAllCategorySQLiteUseCase = getAllCategorySQLiteUseCase
        ) as T
    }
}