package com.agentrediska.hardwarestore.data.storage.database

import com.agentrediska.hardwarestore.data.storage.model.ProductData

interface IProductLocaleDatabaseStorage {

     suspend fun getAllProductByPreCategoryId( preCategoryId: Int) : List<ProductData>

     suspend fun saveProduct( productData: ProductData)
}