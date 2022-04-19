package com.xu.roomdemo01

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class AppContext : Application() {
    companion object {
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}