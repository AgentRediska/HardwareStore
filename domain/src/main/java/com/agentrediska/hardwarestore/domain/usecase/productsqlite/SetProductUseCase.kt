package com.agentrediska.hardwarestore.domain.usecase.productsqlite

import com.agentrediska.hardwarestore.domain.model.Product
import com.agentrediska.hardwarestore.domain.repository.IProductRepositorySQLite

class SetProductUseCase(
    private val productRepository: IProductRepositorySQLite
) {

    suspend fun setProduct( product: Product) {
        productRepository.setProduct( product = product)
    }
}