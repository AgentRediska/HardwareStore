package com.agentrediska.hardwarestore.data.storage

interface ICategoryStorage {

    fun saveCategory(categoryData: CategoryData)

    fun getCategory() : CategoryData
}