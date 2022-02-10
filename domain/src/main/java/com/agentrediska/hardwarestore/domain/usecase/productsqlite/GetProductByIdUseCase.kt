package com.agentrediska.hardwarestore.domain.usecase.productsqlite

import com.agentrediska.hardwarestore.domain.model.Product
import com.agentrediska.hardwarestore.domain.repository.IProductRepositorySQLite

class GetProductByIdUseCase(private val productRepository: IProductRepositorySQLite) {

   suspend fun getProductById( productId: Int) : Product{
      return productRepository.getProductById( productId)
   }
}