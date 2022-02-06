package com.agentrediska.hardwarestore.data.repository

import com.agentrediska.hardwarestore.data.storage.database.IProductLocaleDatabaseStorage
import com.agentrediska.hardwarestore.data.storage.model.ProductData
import com.agentrediska.hardwarestore.domain.model.Product
import com.agentrediska.hardwarestore.domain.repository.IProductRepositorySQLite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ProductRepositorySQLite(
    private val productStorage: IProductLocaleDatabaseStorage
) : IProductRepositorySQLite{

    override suspend fun getAllProductByPreCategoryId(preCategoryId: Int): List<Product> {
        val allProductList = mutableListOf<Product>()
        coroutineScope {
            launch( Dispatchers.IO) {
                val allProductDataList = productStorage.getAllProductByPreCategoryId( preCategoryId)
                allProductDataList.forEach {
                    val product = Product(
                        id = it._id,
                        preCategoryId = it._id_pre_category,
                        name = it.name,
                        vendorCode = it.vendor_code,
                        price = it.price,
                        typeCount = it.type_count
                    )
                    allProductList.add(product)
                }
            }
        }
        return allProductList
    }

    override suspend fun setProduct(product: Product) {
        coroutineScope {
            launch( Dispatchers.IO) {
                val productData = with(product) {
                    ProductData(
                        _id = id,
                        _id_pre_category = preCategoryId,
                        name = name,
                        vendor_code = vendorCode,
                        price = price,
                        type_count = typeCount
                    )
                }
                productStorage.saveProduct(productData = productData)
            }
        }
    }

}