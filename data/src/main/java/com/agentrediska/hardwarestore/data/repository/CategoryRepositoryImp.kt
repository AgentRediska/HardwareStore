package com.agentrediska.hardwarestore.data.repository

import com.agentrediska.hardwarestore.data.storage.CategoryInStorage
import com.agentrediska.hardwarestore.data.storage.CategoryStorage
import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.repository.CategoryRepository


class CategoryRepositoryImp( private val categoryStorage: CategoryStorage): CategoryRepository {

    override fun getCategory(): Category {
        val categoryInStorage = categoryStorage.get()
        return Category(id = categoryInStorage.id, name = categoryInStorage.name)
    }

    override fun testSetCategory(category: Category) {
        val categoryInStorage = CategoryInStorage(id = category.id, name = category.name)
        categoryStorage.save(categoryInStorage)
    }

}