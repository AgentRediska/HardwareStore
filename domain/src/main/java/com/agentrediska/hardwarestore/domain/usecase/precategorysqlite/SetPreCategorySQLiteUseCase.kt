package com.agentrediska.hardwarestore.domain.usecase.precategorysqlite

import com.agentrediska.hardwarestore.domain.model.PreCategory
import com.agentrediska.hardwarestore.domain.repository.IPreCategoryRepositorySQLite

class SetPreCategorySQLiteUseCase(
    private val iPreCategoryRepository: IPreCategoryRepositorySQLite
) {

   suspend fun setPreCategory( preCategory: PreCategory) {
        iPreCategoryRepository.setPreCategory(preCategory = preCategory)
    }
}