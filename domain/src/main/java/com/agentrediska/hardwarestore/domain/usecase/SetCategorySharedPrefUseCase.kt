package com.agentrediska.hardwarestore.domain.usecase

import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.repository.ICategoryRepositorySharedPref

class SetCategorySharedPrefUseCase(private val iCategoryRepositorySharedPref: ICategoryRepositorySharedPref) {

    fun setCategory( category: Category) : Boolean{
        return if(category.id == 0 || category.name.isEmpty()){
            false
        }else{
            iCategoryRepositorySharedPref.testSetCategory(category = category)
            true
        }

    }
}