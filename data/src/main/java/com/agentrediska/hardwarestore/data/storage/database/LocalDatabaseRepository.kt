package com.agentrediska.hardwarestore.data.storage.database

import android.content.Context
import androidx.room.Room
import com.agentrediska.hardwarestore.data.storage.CategoryData
import com.agentrediska.hardwarestore.data.storage.ICategoryStorage
import java.lang.IllegalStateException

private const val DATABASE_NAME = "hardwarestore-database"

class LocalDatabaseRepository private constructor( context: Context) : ICategoryStorage {

    private val database : LocalDatabase = Room.databaseBuilder(
        context.applicationContext,
        LocalDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val databaseDao = database.dao()

    override fun getCategory(): CategoryData = databaseDao.getCategory()

    override fun saveCategory(categoryData: CategoryData) = databaseDao.saveCategory(categoryData)

    companion object {
        private var INSTANCE: LocalDatabaseRepository? = null

        fun initialize( context: Context) {
            if(INSTANCE ==null){
                INSTANCE = LocalDatabaseRepository( context = context)
            }
        }

        fun get(): LocalDatabaseRepository {
            return INSTANCE ?:
            throw IllegalStateException("LocalDatabaseRepository must be initialized")
        }
    }
}