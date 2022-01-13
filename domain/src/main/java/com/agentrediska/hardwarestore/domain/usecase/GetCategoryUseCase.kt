package com.agentrediska.hardwarestore.domain.usecase

import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.repository.CategoryRepository

class GetCategoryUseCase( private val categoryRepository: CategoryRepository) {

    fun getCategory() : Category{
       return categoryRepository.getCategory()
    }
}