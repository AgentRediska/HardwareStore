package com.agentrediska.hardwarestore.data.storage.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.agentrediska.hardwarestore.data.storage.CategoryData

@Dao
interface Dao {

    @Insert
     suspend fun saveCategory(categoryData: CategoryData)

    @Query("SELECT * FROM categorydata WHERE _id=1")
    suspend fun getCategory(): CategoryData
}