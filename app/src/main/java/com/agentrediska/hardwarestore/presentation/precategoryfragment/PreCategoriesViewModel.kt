package com.agentrediska.hardwarestore.presentation.precategoryfragment

import android.os.Bundle
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

     fun setPreCategory( preCategory: PreCategory) {
        viewModelScope.launch {
          setPreCategorySQLiteUseCase.setPreCategory( preCategory = preCategory)
        }
    }

}