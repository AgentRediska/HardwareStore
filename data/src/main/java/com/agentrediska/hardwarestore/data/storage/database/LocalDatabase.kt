package com.agentrediska.hardwarestore.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.agentrediska.hardwarestore.data.storage.model.CategoryData
import com.agentrediska.hardwarestore.data.storage.model.PreCategoryData
import com.agentrediska.hardwarestore.data.storage.model.ProductData

@Database( entities = [CategoryData::class, PreCategoryData::class, ProductData::class], version = 1)
abstract class LocalDatabase: RoomDatabase() {

    abstract fun dao(): Dao
}