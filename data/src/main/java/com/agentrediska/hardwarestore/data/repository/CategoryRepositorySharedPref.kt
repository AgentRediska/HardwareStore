package com.agentrediska.hardwarestore.data.repository

import com.agentrediska.hardwarestore.data.storage.ICategoryStorage
import com.agentrediska.hardwarestore.data.storage.CategoryData
import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.repository.ICategoryRepositorySharedPref


class CategoryRepositorySharedPref(private val iCategoryStorage: ICategoryStorage): ICategoryRepositorySharedPref {

    override fun getCategory(): Category {
        val categoryInStorage = iCategoryStorage.getCategory()
        return Category(id = categoryInStorage._id, name = categoryInStorage.name)
    }

    override fun testSetCategory(category: Category) {
        val categoryInStorage = CategoryData(_id = category.id, name = category.name)
        iCategoryStorage.saveCategory(categoryInStorage)
    }

}