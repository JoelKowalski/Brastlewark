package com.example.brastlewarkmobiletest

import android.app.Application
import com.example.brastlewarkmobiletest.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BrastlewarkMobileTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BrastlewarkMobileTestApplication)
            modules(appModules)
        }
    }
}