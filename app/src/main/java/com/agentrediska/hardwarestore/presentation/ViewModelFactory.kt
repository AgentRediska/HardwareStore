package com.agentrediska.hardwarestore.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agentrediska.hardwarestore.domain.usecase.categorysqlite.GetAllCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.categorysqlite.GetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.categorysqlite.SetCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.GetAllPreCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.precategorysqlite.SetPreCategorySQLiteUseCase
import com.agentrediska.hardwarestore.domain.usecase.productsqlite.GetAllProductsUseCase
import com.agentrediska.hardwarestore.domain.usecase.productsqlite.SetProductUseCase
import com.agentrediska.hardwarestore.presentation.categoryfragment.CategoriesViewModel
import com.agentrediska.hardwarestore.presentation.precategoryfragment.PreCategoriesViewModel
import com.agentrediska.hardwarestore.presentation.productfragment.ProductViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    //Category
    private val setCategorySQLiteUseCase: SetCategorySQLiteUseCase,
    private val getCategorySQLiteUseCase: GetCategorySQLiteUseCase,
    private val getAllCategorySQLiteUseCase: GetAllCategorySQLiteUseCase,
    //PreCategory
    private val getAllPreCategorySQLiteUseCase: GetAllPreCategorySQLiteUseCase,
    private val setPreCategorySQLiteUseCase: SetPreCategorySQLiteUseCase,
    //Product
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val setProductUseCase: SetProductUseCase
): ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom( CategoriesViewModel::class.java) ->
                return CategoriesViewModel(
                    setCategorySQLiteUseCase, getCategorySQLiteUseCase, getAllCategorySQLiteUseCase
                ) as T

            modelClass.isAssignableFrom( PreCategoriesViewModel::class.java) ->
                return PreCategoriesViewModel(
                    getAllPreCategorySQLiteUseCase,
                    setPreCategorySQLiteUseCase
                ) as T

            modelClass.isAssignableFrom( ProductViewModel::class.java) ->
                return ProductViewModel(
                    getAllProductsUseCase,
                    setProductUseCase
                ) as T
        }
        return modelClass.newInstance()
    }
}