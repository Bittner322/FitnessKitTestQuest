package com.example.fitnesskittestquest.di

import com.example.fitnesskittestquest.data.database.databases.FitnessDatabase
import com.example.fitnesskittestquest.data.network.FitnessService
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    NetworkModule::class,
    DatabaseModule::class,
])
@Singleton
interface AppComponent {

    val database: FitnessDatabase
    val network: FitnessService

}