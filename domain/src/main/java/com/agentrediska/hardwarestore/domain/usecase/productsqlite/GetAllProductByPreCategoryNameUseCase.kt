package com.agentrediska.hardwarestore.domain.usecase.productsqlite

import com.agentrediska.hardwarestore.domain.model.Product
import com.agentrediska.hardwarestore.domain.repository.IProductRepositorySQLite

class GetAllProductByPreCategoryNameUseCase(private val iProductRepositorySQLite: IProductRepositorySQLite) {

   suspend fun getAllProductByPreCategory( preCategoryName: String): List<Product>{
        return iProductRepositorySQLite.getProductByPreCategoryName( preCategoryName)
    }
}