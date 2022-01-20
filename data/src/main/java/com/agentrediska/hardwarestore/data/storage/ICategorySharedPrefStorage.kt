package com.agentrediska.hardwarestore.data.storage

import com.agentrediska.hardwarestore.data.storage.model.CategoryData

interface ICategorySharedPrefStorage {

    fun saveCategory(categoryData: CategoryData)

    fun getCategory() : CategoryData
}