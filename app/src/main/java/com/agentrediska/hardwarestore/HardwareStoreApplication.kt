package com.agentrediska.hardwarestore

import android.app.Application
import com.agentrediska.hardwarestore.data.storage.database.LocalDatabaseRepository

class HardwareStoreApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LocalDatabaseRepository.initialize( this)
    }
}