package com.agentrediska.hardwarestore.domain.usecase

import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.repository.AllCategoryRepository
import com.agentrediska.hardwarestore.domain.repository.CategoryRepository

class GetAllCategoriesUseCase(private val allCategoryRepository: AllCategoryRepository) {

    fun getAllCategories() : List<Category>{
        val listOfAllCategories = listOf<Category>()
        return listOfAllCategories
    }

}