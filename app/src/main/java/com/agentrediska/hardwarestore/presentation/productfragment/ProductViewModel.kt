package com.agentrediska.hardwarestore.presentation.productfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agentrediska.hardwarestore.domain.model.Product
import com.agentrediska.hardwarestore.domain.usecase.productsqlite.GetAllProductsUseCase
import com.agentrediska.hardwarestore.domain.usecase.productsqlite.SetProductUseCase
import kotlinx.coroutines.launch

class ProductViewModel (
 private val getAllProductsUseCase: GetAllProductsUseCase,
 private val setProductUseCase: SetProductUseCase
) : ViewModel() {

    private val allProductLiveData = MutableLiveData<List<Product>>()
    val allProductLD: LiveData<List<Product>> = allProductLiveData

    fun getAllProductByPreCategoryId( preCategoryId: Int) {
        viewModelScope.launch {
            allProductLiveData.value = getAllProductsUseCase.getAllProductsByPreCategoryId(preCategoryId)
        }
    }

    fun setProduct( product: Product) {
        viewModelScope.launch {
            setProductUseCase.setProduct( product)
        }
    }

}