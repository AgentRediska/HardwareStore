package com.agentrediska.hardwarestore.data.storage

import android.content.Context

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_NAME_CATEGORY = "name_category"
private const val KEY_ID_CATEGORY = "id_category"
private const val DEFAULT_NAME_CATEGORY = "Unsigned CategoryData"

class SharedPreferenceStorage( context: Context) : ICategoryStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveCategory(categoryData: com.agentrediska.hardwarestore.data.storage.CategoryData) {
        sharedPreferences.edit().putInt(KEY_ID_CATEGORY, categoryData._id).apply()
        sharedPreferences.edit().putString(KEY_NAME_CATEGORY, categoryData.name).apply()
    }
    override fun getCategory(): com.agentrediska.hardwarestore.data.storage.CategoryData {
        val idOfCategory = sharedPreferences.getInt(KEY_ID_CATEGORY, 0)
        val nameOfCategory = sharedPreferences.getString(KEY_NAME_CATEGORY, DEFAULT_NAME_CATEGORY) ?: DEFAULT_NAME_CATEGORY
        return com.agentrediska.hardwarestore.data.storage.CategoryData(_id = idOfCategory, name = nameOfCategory)
    }
}