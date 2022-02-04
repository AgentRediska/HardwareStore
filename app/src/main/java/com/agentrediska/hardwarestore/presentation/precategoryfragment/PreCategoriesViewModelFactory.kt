package com.agentrediska.hardwarestore.presentation.precategoryfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.GetAllPreCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.SetPreCategorySQLiteUseCase

class PreCategoriesViewModelFactory(
   private val getAllPreCategorySQLiteUseCase: GetAllPreCategorySQLiteUseCase,
   private val setPreCategorySQLiteUseCase: SetPreCategorySQLiteUseCase
    ) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PreCategoriesViewModel(
            getAllPreCategorySQLiteUseCase = getAllPreCategorySQLiteUseCase,
            setPreCategorySQLiteUseCase=  setPreCategorySQLiteUseCase
        ) as T
    }


}