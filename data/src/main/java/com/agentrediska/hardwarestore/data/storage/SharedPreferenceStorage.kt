package com.agentrediska.hardwarestore.data.storage

import android.content.Context
import com.agentrediska.hardwarestore.domain.model.Category

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_NAME_CATEGORY = "name_category"
private const val KEY_ID_CATEGORY = "id_category"
private const val DEFAULT_NAME_CATEGORY = "Unsigned Category"

class SharedPreferenceStorage( context: Context) : CategoryStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(category: CategoryInStorage) {
        sharedPreferences.edit().putInt(KEY_ID_CATEGORY, category.id).apply()
        sharedPreferences.edit().putString(KEY_NAME_CATEGORY, category.name).apply()
    }
    override fun get(): CategoryInStorage {
        val idOfCategory = sharedPreferences.getInt(KEY_ID_CATEGORY, 0)
        val nameOfCategory = sharedPreferences.getString(KEY_NAME_CATEGORY, DEFAULT_NAME_CATEGORY) ?: DEFAULT_NAME_CATEGORY
        return CategoryInStorage(id = idOfCategory, name = nameOfCategory)
    }
}