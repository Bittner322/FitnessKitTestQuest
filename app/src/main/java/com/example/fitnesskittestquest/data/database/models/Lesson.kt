package com.example.fitnesskittestquest.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Lessons")
data class Lesson(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "place") val place: String,
    @ColumnInfo(name = "coach_id") val coachId: String,
    @ColumnInfo(name = "startTime") val startTime: String,
    @ColumnInfo(name = "endTime") val endTime: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "appointment_id") val appointmentId : String,
    @ColumnInfo(name = "service_id") val serviceId : String,
    @ColumnInfo(name = "available_slots") val availableSlots: Int,
    @ColumnInfo(name = "commercial") val commercial: Boolean,
    @ColumnInfo(name = "client_recorded") val clientRecorded: Boolean,
    @ColumnInfo(name = "is_cancelled") val isCancelled: Boolean,
    @ColumnInfo(name = "tab") val tab: String,
    @ColumnInfo(name = "color") val color: String,
    @ColumnInfo(name = "tab_id") val tabId: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}