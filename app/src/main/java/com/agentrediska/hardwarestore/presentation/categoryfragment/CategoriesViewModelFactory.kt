package com.agentrediska.hardwarestore.presentation.categoryfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agentrediska.hardwarestore.domain.usecase.*

class CategoriesViewModelFactory( val setCategorySQLiteUseCase: SetCategorySQLiteUseCase,
                                  val getCategorySQLiteUseCase: GetCategorySQLiteUseCase,
                                  val getAllCategorySQLiteUseCase: GetAllCategorySQLiteUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoriesViewModel(
            setCategorySQLiteUseCase = setCategorySQLiteUseCase,
            getCategorySQLiteUseCase = getCategorySQLiteUseCase,
            getAllCategorySQLiteUseCase = getAllCategorySQLiteUseCase
        ) as T
    }

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

   /* private val categoryRepositoryLocalDatabase by lazy {
        CategoryRepositorySQLite(LocalDatabaseStorage.get())
    }*/

   /* private val getCategorySQLiteUseCase by lazy {
        GetCategorySQLiteUseCase(iCategoryRepositorySQLite = categoryRepositoryLocalDatabase)
    }

    private val getAllCategorySQLiteUseCase by lazy {
        GetAllCategorySQLiteUseCase( iCategoryRepositorySQLite = categoryRepositoryLocalDatabase)
    }

    private val setCategorySQLiteUseCase by lazy {
        SetCategorySQLiteUseCase(iCategoryRepositorySQLite = categoryRepositoryLocalDatabase)
    }*/

}