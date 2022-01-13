package com.agentrediska.hardwarestore.data.repository

import android.content.Context
import com.agentrediska.hardwarestore.domain.repository.AllCategoryRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_NAME_CATEGORY = "nameOfCategory"

class AllCategoryRepositoryImp(private val context: Context) : AllCategoryRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun getAllCategory() {
        TODO("Not yet implemented")
    }
}