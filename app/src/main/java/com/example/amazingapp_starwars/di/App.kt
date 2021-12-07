package com.example.amazingapp_starwars.di

import android.app.Application
import com.example.data.db.RoomAppDataBase

class App :Application() {
    companion object{
        lateinit var roomAppDataBase: RoomAppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        roomAppDataBase = RoomAppDataBase.buildDataSourse(context = applicationContext) as RoomAppDataBase
    }
}