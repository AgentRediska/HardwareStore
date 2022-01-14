package com.agentrediska.hardwarestore.domain.usecase

import com.agentrediska.hardwarestore.domain.model.Category
import com.agentrediska.hardwarestore.domain.repository.ICategoryRepositorySQLite

class SetCategorySQLiteUseCase( private val iCategoryRepositorySQLite: ICategoryRepositorySQLite) {

    fun setCategory( category: Category) : Boolean{
        return if(category.id == 0 || category.name.isEmpty()){
            false
        }else{
            iCategoryRepositorySQLite.setCategory(category = category)
            true
        }

    }
}