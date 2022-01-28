package com.agentrediska.hardwarestore.data.storage.database

import android.content.Context
import androidx.room.Room
import com.agentrediska.hardwarestore.data.storage.model.CategoryData
import com.agentrediska.hardwarestore.data.storage.model.PreCategoryData
import java.lang.IllegalStateException

private const val DATABASE_NAME = "hardwarestore-database"

class LocalDatabaseStorage private constructor(
    context: Context
) : ICategoryLocaleDatabaseStorage, IPreCategoryLocaleDatabaseStorage {

    private val database : LocalDatabase = Room.databaseBuilder(
        context.applicationContext,
        LocalDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val databaseDao = database.dao()

    companion object {
        private var INSTANCE: LocalDatabaseStorage? = null

        fun initialize( context: Context) {
            if(INSTANCE ==null){
                INSTANCE = LocalDatabaseStorage( context = context)
            }
        }

        fun get(): LocalDatabaseStorage {
            return INSTANCE ?:
            throw IllegalStateException("LocalDatabaseStorage must be initialized")
        }
    }

    override suspend fun getCategory(): CategoryData = databaseDao.getCategory()

    override suspend fun getAllCategory(): List<CategoryData> = databaseDao.getAllCategory()

    override suspend fun saveCategory(categoryData: CategoryData) {
        databaseDao.saveCategory(categoryData = categoryData)
    }

    override suspend fun savePreCategory(preCategoryData: PreCategoryData) {
        databaseDao.savePreCategory(preCategoryData = preCategoryData)
    }

    override suspend fun getPreCategory(): PreCategoryData = databaseDao.getPreCategory()

    override suspend fun getAllPreCategory(): List<PreCategoryData> = databaseDao.getAllPreCategory()
}