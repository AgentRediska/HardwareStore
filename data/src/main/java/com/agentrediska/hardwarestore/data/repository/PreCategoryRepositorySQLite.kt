package com.agentrediska.hardwarestore.data.repository

import com.agentrediska.hardwarestore.data.storage.database.IPreCategoryLocaleDatabaseStorage
import com.agentrediska.hardwarestore.data.storage.model.PreCategoryData
import com.agentrediska.hardwarestore.domain.model.PreCategory
import com.agentrediska.hardwarestore.domain.repository.IPreCategoryRepositorySQLite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class PreCategoryRepositorySQLite(
    private val categoryStorage: IPreCategoryLocaleDatabaseStorage
    ) : IPreCategoryRepositorySQLite {

    override suspend fun getPreCategory(): PreCategory {
        val preCategoryInStorage = categoryStorage.getPreCategory()
        return PreCategory(
            id = preCategoryInStorage._id,
            categoryId = preCategoryInStorage._id_category,
            name = preCategoryInStorage.name)
    }

    override suspend fun getPreCategoryById(id: Int): PreCategory {
        TODO("Not yet implemented")
    }

    override suspend fun setPreCategory(preCategory: PreCategory) {
        coroutineScope {
            launch(Dispatchers.IO){
                val preCategoryData = PreCategoryData(
                    _id = preCategory.id,
                    _id_category = preCategory.categoryId,
                    name = preCategory.name
                    )
                categoryStorage.savePreCategory(preCategoryData)
            }
        }
    }

    override suspend fun getAllPreCategory(): List<PreCategory> {
        val allPreCategoryList = mutableListOf<PreCategory>()
        coroutineScope {
            launch( Dispatchers.IO) {
                val allPreCategoryDataList = categoryStorage.getAllPreCategory()
                allPreCategoryDataList.forEach {
                val preCategory = PreCategory(
                    id = it._id,
                    categoryId = it._id_category,
                    name = it.name
                )
                    allPreCategoryList.add(preCategory)
                }
            }
        }
        return allPreCategoryList
    }
}