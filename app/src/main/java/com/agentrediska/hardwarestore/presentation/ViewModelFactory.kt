package com.agentrediska.hardwarestore.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agentrediska.hardwarestore.app.HardwareStoreApplication
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
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(): ViewModelProvider.Factory{
    //Category
    @Inject
    lateinit var setCategorySQLiteUseCase: SetCategorySQLiteUseCase
    @Inject
    lateinit var getCategorySQLiteUseCase: GetCategorySQLiteUseCase
    @Inject
    lateinit var getAllCategorySQLiteUseCase: GetAllCategorySQLiteUseCase
    //PreCategory
    @Inject
    lateinit var getAllPreCategorySQLiteUseCase: GetAllPreCategorySQLiteUseCase
    @Inject
    lateinit var setPreCategorySQLiteUseCase: SetPreCategorySQLiteUseCase
    //Product
   /* @Inject
    lateinit var getAllProductsUseCase: GetAllProductsUseCase
    @Inject
    lateinit var setProductUseCase: SetProductUseCase*/

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

          /*  modelClass.isAssignableFrom( ProductViewModel::class.java) ->
                return ProductViewModel(
                    getAllProductsUseCase,
                    setProductUseCase
                ) as T*/
        }
        return modelClass.newInstance()
    }
}