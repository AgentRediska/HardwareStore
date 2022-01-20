package com.agentrediska.hardwarestore.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.agentrediska.hardwarestore.data.storage.model.CategoryData

@Database( entities = [CategoryData::class], version = 1)
abstract class LocalDatabase: RoomDatabase() {

    abstract fun dao(): Dao
}