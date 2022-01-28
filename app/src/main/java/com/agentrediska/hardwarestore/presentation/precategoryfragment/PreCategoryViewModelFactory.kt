package com.agentrediska.hardwarestore.presentation.precategoryfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.GetAllPreCategorySQLiteUseCase

class PreCategoryViewModelFactory(
    val getAllPreCategorySQLiteUseCase: GetAllPreCategorySQLiteUseCase
    ) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PreCategoryViewModel(
            getAllPreCategorySQLiteUseCase = getAllPreCategorySQLiteUseCase
        ) as T
    }


}