package com.agentrediska.hardwarestore.domain.repository

import com.agentrediska.hardwarestore.domain.model.Product


interface IProductRepositorySQLite {

    suspend fun getAllProductByPreCategoryId( preCategoryId: Int): List<Product>

    suspend fun setProduct( product: Product)
}