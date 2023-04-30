package com.example.fitnesskittestquest.data.repositories

import com.example.fitnesskittestquest.data.database.databases.FitnessDatabase
import com.example.fitnesskittestquest.data.database.models.Lesson
import com.example.fitnesskittestquest.data.database.models.Trainer
import com.example.fitnesskittestquest.data.network.FitnessService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FitnessRepository @Inject constructor(
    private val fitnessService: FitnessService,
    private val fitnessDatabase: FitnessDatabase,
) {

    suspend fun loadAllLessonsIntoDatabase(): Result<Unit> {
        return runCatching {
            val lessons = getLessonsFromNetwork()
            fitnessDatabase.fitnessDao().insertAllLessons(lessons)
        }
    }

    suspend fun loadAllTrainersIntoDatabase(): Result<Unit> {
        return runCatching {
            val trainers = getAllTrainersFromNetwork()
            fitnessDatabase.fitnessDao().insertAllTrainers(trainers)
        }
    }

    fun getAllLessons(): Flow<List<Lesson>> {
        return fitnessDatabase.fitnessDao().getAllLessons()
    }

    private suspend fun getLessonsFromNetwork(): List<Lesson> {
        val mappedLessons = fitnessService.getInfo().lessons.map { response ->
            Lesson(
                name = response.name,
                description = response.description,
                place = response.place,
                coachId = response.coachId,
                startTime = response.startTime,
                endTime = response.endTime,
                date = response.date,
                appointmentId = response.appointmentId,
                serviceId = response.serviceId,
                availableSlots = response.availableSlots,
                commercial = response.commercial,
                clientRecorded = response.clientRecorded,
                isCancelled = response.isCancelled,
                tab = response.tab,
                color = response.color,
                tabId = response.tabId
            )
        }
        return mappedLessons
    }

    private suspend fun getAllTrainersFromNetwork(): List<Trainer> {
        return fitnessService.getInfo().trainers.map { response ->
            Trainer(
                id = response.id,
                fullName = response.fullName,
                trainer_name = response.name,
                lastName = response.lastName,
                position = response.position,
                imageUrl = response.imageUrl,
                imageUrlSmall = response.imageUrlSmall,
                imageUrlMedium = response.imageUrlMedium,
                description = response.description
            )
        }
    }
}