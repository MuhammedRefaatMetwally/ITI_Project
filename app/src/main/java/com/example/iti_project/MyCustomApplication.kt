package com.example.iti_project

import android.app.Application
import com.example.iti_project.core.data_source.local_data_source.AppSharedReferences

class MyCustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppSharedReferences.init(this)
    }
}