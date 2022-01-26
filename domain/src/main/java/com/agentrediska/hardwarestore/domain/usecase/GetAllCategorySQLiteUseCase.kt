package com.agentrediska.hardwarestore.domain.usecase

import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.repository.ICategoryRepositorySQLite

class GetAllCategorySQLiteUseCase(private val iCategoryRepositorySQLite: ICategoryRepositorySQLite) {

    suspend fun getAllCategories() : List<Category>{
       return iCategoryRepositorySQLite.getAllCategory()
    }

}