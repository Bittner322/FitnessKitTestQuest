package com.example.fitnesskittestquest

import android.app.Application
import android.content.Context
import com.example.fitnesskittestquest.data.database.databases.FitnessDatabase
import com.example.fitnesskittestquest.di.ComponentStorage
import com.example.fitnesskittestquest.di.DaggerAppComponent
import com.example.fitnesskittestquest.di.initRootComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.plus

class FitnessApplication: Application() {

    companion object {
        private lateinit var instance: FitnessApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        ComponentStorage.initRootComponent { DaggerAppComponent.create() }
        FitnessDatabase.initDatabase(this)
    }
}