package org.areeb.newsapp

import KoinInitializer
import android.app.Application

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
//        startKoin {
//            androidContext(this@MainApplication)
//            androidLogger()
//            modules(commonModules())
//        }
        KoinInitializer(applicationContext).init()
    }
}