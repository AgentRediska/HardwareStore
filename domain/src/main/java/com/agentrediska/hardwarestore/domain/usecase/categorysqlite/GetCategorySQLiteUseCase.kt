package com.agentrediska.hardwarestore.domain.usecase.categorysqlite

import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.repository.ICategoryRepositorySQLite
import com.agentrediska.hardwarestore.domain.repository.ICategoryRepositorySharedPref

class GetCategorySQLiteUseCase(private val iCategoryRepositorySQLite: ICategoryRepositorySQLite) {

   suspend fun getCategory(): Category {
        return iCategoryRepositorySQLite.getCategory()
    }
}