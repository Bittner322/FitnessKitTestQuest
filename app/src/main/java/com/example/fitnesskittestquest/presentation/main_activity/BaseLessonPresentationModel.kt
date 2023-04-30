package com.example.fitnesskittestquest.presentation.main_activity

import com.example.fitnesskittestquest.data.database.models.Lesson

sealed class BaseLessonPresentationModel {

    class Item(lesson: Lesson): BaseLessonPresentationModel() {
        val lesson = lesson
    }

    class Date(date: String): BaseLessonPresentationModel() {
        val date = date
    }
}
