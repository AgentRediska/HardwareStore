package com.agentrediska.hardwarestore.data.storage

interface ICategoryLocaleDatabaseStorage {

   suspend fun saveCategory(categoryData: CategoryData)

    suspend fun getCategory() : CategoryData
}