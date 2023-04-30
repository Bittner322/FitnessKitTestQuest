package com.example.fitnesskittestquest.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.fitnesskittestquest.data.database.models.Lesson
import com.example.fitnesskittestquest.data.database.models.Trainer
import kotlinx.coroutines.flow.Flow

@Dao
interface FitnessDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(lesson: Lesson)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllLessons(lessons: List<Lesson>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllTrainers(trainers: List<Trainer>)

    @Update
    suspend fun update(lesson: Lesson)

    @Delete
    suspend fun delete(lesson: Lesson)

    @Query("SELECT * FROM Lessons")
    fun getAllLessons(): Flow<List<Lesson>>
}