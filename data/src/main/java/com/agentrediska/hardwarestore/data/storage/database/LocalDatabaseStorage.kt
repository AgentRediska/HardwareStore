package com.agentrediska.hardwarestore.data.storage.database

import android.content.Context
import androidx.room.Room
import com.agentrediska.hardwarestore.data.storage.model.CategoryData
import com.agentrediska.hardwarestore.data.storage.ICategoryLocaleDatabaseStorage
import java.lang.IllegalStateException

private const val DATABASE_NAME = "hardwarestore-database"

class LocalDatabaseStorage private constructor(context: Context) : ICategoryLocaleDatabaseStorage {

    private val database : LocalDatabase = Room.databaseBuilder(
        context.applicationContext,
        LocalDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val databaseDao = database.dao()

    override suspend fun getCategory(): CategoryData = databaseDao.getCategory()

    override suspend fun getAllCategory(): List<CategoryData> {
        return databaseDao.getAllCategory()
    }

    override suspend fun saveCategory(categoryData: CategoryData) = databaseDao.saveCategory(categoryData)

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
}