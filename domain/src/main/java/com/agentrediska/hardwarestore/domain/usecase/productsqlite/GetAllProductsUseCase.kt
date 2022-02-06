package com.agentrediska.hardwarestore.domain.usecase.productsqlite

import com.agentrediska.hardwarestore.domain.model.Product
import com.agentrediska.hardwarestore.domain.repository.IProductRepositorySQLite

class GetAllProductsUseCase(
   private val productRepository: IProductRepositorySQLite
){

   suspend fun getAllProductsByPreCategoryId( preCategoryId: Int) : List<Product>{
        return productRepository.getAllProductByPreCategoryId( preCategoryId = preCategoryId)
    }
}