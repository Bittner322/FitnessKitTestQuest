package com.example.fitnesskittestquest.presentation.main_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fitnesskittestquest.data.database.models.Lesson
import com.example.fitnesskittestquest.data.repositories.FitnessRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val fitnessRepository: FitnessRepository
): ViewModel() {

    val adapterList = MutableStateFlow(emptyList<BaseLessonPresentationModel>())

    init {
        loadAllLessons()
        loadAllTrainers()
        observeLessons()
    }

    private fun loadAllLessons() {
        viewModelScope.launch {
            fitnessRepository.loadAllLessonsIntoDatabase()
        }
    }

    private fun loadAllTrainers() {
        viewModelScope.launch {
            fitnessRepository.loadAllTrainersIntoDatabase()
        }
    }

    private fun observeLessons() {
        fitnessRepository.getAllLessons()
            .onEach {
                adapterList.value = createLessonsListWithDates(it)
            }
            .launchIn(viewModelScope)
    }

    private fun createLessonsListWithDates(lessons: List<Lesson>): List<BaseLessonPresentationModel> {
        var date: String? = null
        val newLessonsList = mutableListOf<BaseLessonPresentationModel>()

        lessons.forEach {
            if (it.date != date && it.date != null) {
                newLessonsList.add(BaseLessonPresentationModel.Item(it))
                date = it.date
            }
            newLessonsList.add(BaseLessonPresentationModel.Date(it.date))
        }

        adapterList.value = adapterList.value + newLessonsList
        return newLessonsList
    }
}

class MainActivityViewModelFactory @Inject constructor(
    private val fitnessRepository: FitnessRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(fitnessRepository) as T
    }
}