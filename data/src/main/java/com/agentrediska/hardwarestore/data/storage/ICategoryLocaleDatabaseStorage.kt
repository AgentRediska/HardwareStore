package com.agentrediska.hardwarestore.data.storage

import com.agentrediska.hardwarestore.data.storage.model.CategoryData

interface ICategoryLocaleDatabaseStorage {

   suspend fun saveCategory(categoryData: CategoryData)

    suspend fun getCategory() : CategoryData

    suspend fun getAllCategory() : List<CategoryData>
}