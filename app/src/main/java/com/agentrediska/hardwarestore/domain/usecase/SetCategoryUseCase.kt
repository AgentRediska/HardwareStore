package com.agentrediska.hardwarestore.domain.usecase

import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.repository.CategoryRepository

class SetCategoryUseCase( private val categoryRepository: CategoryRepository) {

    fun setCategory( category: Category) : Boolean{
        return if(category.id == 0 || category.name.isEmpty()){
            false
        }else{
            categoryRepository.testSetCategory(category = category)
            true
        }

    }
}