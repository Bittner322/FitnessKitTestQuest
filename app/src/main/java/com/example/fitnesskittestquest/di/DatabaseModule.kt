package com.example.fitnesskittestquest.di

import com.example.fitnesskittestquest.data.database.databases.FitnessDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideArticleDatabase(): FitnessDatabase = FitnessDatabase.INSTANCE

}