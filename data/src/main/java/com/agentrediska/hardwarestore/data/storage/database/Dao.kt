package com.agentrediska.hardwarestore.data.storage.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.agentrediska.hardwarestore.data.storage.model.CategoryData
import com.agentrediska.hardwarestore.data.storage.model.PreCategoryData
import com.agentrediska.hardwarestore.data.storage.model.ProductData

@Dao
interface Dao {

    //Category
    @Insert
     suspend fun saveCategory(categoryData: CategoryData)

    @Query("SELECT * FROM categorydata WHERE _id=1")
    suspend fun getCategory(): CategoryData

    @Query( "SELECT * FROM categorydata")
    suspend fun getAllCategory(): List<CategoryData>

    //PreCategory
    @Insert
    suspend fun savePreCategory(preCategoryData: PreCategoryData)

    @Query("SELECT * FROM precategorydata WHERE _id=1")
    suspend fun getPreCategory(): PreCategoryData

    @Query( "SELECT * FROM precategorydata WHERE _id_category = :categoryId")
    suspend fun getAllPreCategory( categoryId: Int): List<PreCategoryData>

    //Product
    @Query( "SELECT * FROM productdata WHERE _id_pre_category = :preCategoryId")
    suspend fun getAllProduct( preCategoryId: Int) : List<ProductData>

    @Insert
    suspend fun saveProduct( productData: ProductData)
}