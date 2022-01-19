package com.agentrediska.hardwarestore.data.repository

import com.agentrediska.hardwarestore.data.storage.CategoryData
import com.agentrediska.hardwarestore.data.storage.ICategoryLocaleDatabaseStorage
import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.repository.ICategoryRepositorySQLite
import kotlinx.coroutines.*

class CategoryRepositorySQLite(
    private val iCategoryStorage: ICategoryLocaleDatabaseStorage): ICategoryRepositorySQLite {

    override suspend fun getCategory(): Category {
        val categoryInStorage = iCategoryStorage.getCategory()
        return Category(id = categoryInStorage._id, name = categoryInStorage.name)
    }

    override suspend fun getCategoryById(id: Int): Category {
        TODO("Not yet implemented")
    }


    override suspend fun setCategory(category: Category) {
        coroutineScope {
            launch(Dispatchers.IO) {
                val categoryInStorage = CategoryData(_id = category.id, name = category.name)
                iCategoryStorage.saveCategory(categoryInStorage)
            }
        }
    }
}

