package com.agentrediska.hardwarestore.presentation.productfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agentrediska.hardwarestore.domain.usecase.productsqlite.GetAllProductsUseCase
import com.agentrediska.hardwarestore.domain.usecase.productsqlite.SetProductUseCase

class ProductViewModelFactory(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val setProductUseCase: SetProductUseCase
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(
            getAllProductsUseCase = getAllProductsUseCase,
            setProductUseCase = setProductUseCase
        ) as T
    }
}