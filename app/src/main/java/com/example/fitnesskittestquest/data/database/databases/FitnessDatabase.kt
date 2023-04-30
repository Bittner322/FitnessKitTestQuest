package com.example.fitnesskittestquest.data.database.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fitnesskittestquest.data.database.dao.FitnessDao
import com.example.fitnesskittestquest.data.database.models.Lesson
import com.example.fitnesskittestquest.data.database.models.Trainer

@Database(entities = [Lesson::class, Trainer::class], version = 2, exportSchema = false)
abstract class FitnessDatabase: RoomDatabase() {

    abstract fun fitnessDao(): FitnessDao

    companion object {

        lateinit var INSTANCE: FitnessDatabase
            private set

        fun initDatabase(context: Context) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                FitnessDatabase::class.java,
                "fitness_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}