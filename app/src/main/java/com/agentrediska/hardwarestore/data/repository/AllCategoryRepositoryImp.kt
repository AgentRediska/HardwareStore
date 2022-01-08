package com.agentrediska.hardwarestore.data.repository

import android.content.Context
import com.agentrediska.hardwarestore.domain.repository.AllCategoryRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_NAME_CATEGORY = "nameOfCategory"

class AllCategoryRepositoryImp(private val context: Context) : AllCategoryRepository {

   // val sharedPreferences = context.getSharedPreferences()

    override fun getAllCategory() {
        TODO("Not yet implemented")
    }

    override fun setAllCategory() {
        TODO("Not yet implemented")
    }
}