package com.agentrediska.hardwarestore.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agentrediska.hardwarestore.data.repository.CategoryRepositorySQLite
import com.agentrediska.hardwarestore.data.repository.CategoryRepositorySharedPref
import com.agentrediska.hardwarestore.data.storage.SharedPreferenceStorage
import com.agentrediska.hardwarestore.data.storage.database.LocalDatabaseRepository
import com.agentrediska.hardwarestore.domain.usecase.GetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.GetCategorySharedPrefUseCase
import com.agentrediska.hardwarestore.domain.usecase.SetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.SetCategorySharedPrefUseCase

class CategoriesViewModelFactory( context: Context) : ViewModelProvider.Factory {

    private val categorySharedPrefRepository by lazy {
        CategoryRepositorySharedPref(SharedPreferenceStorage(context = context) )
    }

    private val categoryRepositoryLocalDatabase by lazy {
        CategoryRepositorySQLite(LocalDatabaseRepository.get())
    }

    private val getCategorySharedPrefUseCase by lazy {
        GetCategorySharedPrefUseCase(iCategoryRepositorySharedPref = categorySharedPrefRepository)
    }

    private val getCategorySQLiteUseCase by lazy {
        GetCategorySQLiteUseCase(iCategoryRepositorySQLite = categoryRepositoryLocalDatabase)
    }

    private val setCategorySharedPrefUseCase by lazy {
        SetCategorySharedPrefUseCase( iCategoryRepositorySharedPref = categorySharedPrefRepository)
    }

    private val setCategorySQLiteUseCase by lazy {
        SetCategorySQLiteUseCase(iCategoryRepositorySQLite = categoryRepositoryLocalDatabase)
    }


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoriesViewModel(
            setCategorySharedPrefUseCase = setCategorySharedPrefUseCase,
            getCategorySharedPrefUseCase = getCategorySharedPrefUseCase,
            setCategorySQLiteUseCase = setCategorySQLiteUseCase,
            getCategorySQLiteUseCase = getCategorySQLiteUseCase
        ) as T
    }
}