package com.agentrediska.hardwarestore.app

import android.app.Application
import com.agentrediska.hardwarestore.data.storage.database.LocalDatabaseStorage
import com.agentrediska.hardwarestore.di.AppComponent
import com.agentrediska.hardwarestore.di.DaggerAppComponent

class HardwareStoreApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        LocalDatabaseStorage.initialize( this)
        appComponent = DaggerAppComponent.create()

    }
}