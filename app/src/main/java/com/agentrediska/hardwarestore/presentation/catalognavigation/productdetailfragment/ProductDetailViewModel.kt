package com.agentrediska.hardwarestore.presentation.catalognavigation.productdetailfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agentrediska.hardwarestore.domain.model.Product
import com.agentrediska.hardwarestore.domain.usecase.productsqlite.GetProductByIdUseCase
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val getProductUseCase: GetProductByIdUseCase
) : ViewModel() {

    private val productLiveData = MutableLiveData<Product>()
    val productLD: LiveData<Product> = productLiveData

    fun getProduct( productId: Int) {
        viewModelScope.launch {
            productLiveData.value = getProductUseCase.getProductById( productId)
        }
    }
}