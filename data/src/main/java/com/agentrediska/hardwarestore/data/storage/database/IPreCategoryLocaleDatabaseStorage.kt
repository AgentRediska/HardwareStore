package com.agentrediska.hardwarestore.data.storage.database

import com.agentrediska.hardwarestore.data.storage.model.CategoryData
import com.agentrediska.hardwarestore.data.storage.model.PreCategoryData

interface IPreCategoryLocaleDatabaseStorage {

    suspend fun savePreCategory( preCategoryData: PreCategoryData)

    suspend fun getPreCategory() : PreCategoryData

    suspend fun getAllPreCategory() : List<PreCategoryData>
}