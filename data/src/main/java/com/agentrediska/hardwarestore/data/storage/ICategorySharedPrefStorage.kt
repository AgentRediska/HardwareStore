package com.agentrediska.hardwarestore.data.storage

interface ICategorySharedPrefStorage {

    fun saveCategory(categoryData: CategoryData)

    fun getCategory() : CategoryData
}