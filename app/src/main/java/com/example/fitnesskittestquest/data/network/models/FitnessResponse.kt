package com.example.fitnesskittestquest.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FitnessResponse(
    @SerialName("trainers")
    val trainers: List<Trainers> = emptyList(),
    @SerialName("tabs")
    val tabs: List<Trainers.Tabs> = emptyList(),
    @SerialName("lessons")
    val lessons: List<Trainers.Tabs.Lessons> = emptyList(),
) {
    @Serializable
    data class Trainers(
        @SerialName("id")
        val id: String,
        @SerialName("full_name")
        val fullName: String,
        @SerialName("name")
        val name: String,
        @SerialName("last_name")
        val lastName: String,
        @SerialName("position")
        val position: String,
        @SerialName("image_url")
        val imageUrl: String,
        @SerialName("image_url_small")
        val imageUrlSmall: String,
        @SerialName("image_url_medium")
        val imageUrlMedium: String,
        @SerialName("description")
        val description: String
    ) {
        @Serializable
        data class Tabs(
            @SerialName("id")
            val id: Int,
            @SerialName("name")
            val name: String
        ) {
            @Serializable
            data class Lessons(
                @SerialName("name")
                val name: String,
                @SerialName("description")
                val description: String,
                @SerialName("place")
                val place: String,
                @SerialName("coach_id")
                val coachId: String,
                @SerialName("startTime")
                val startTime: String,
                @SerialName("endTime")
                val endTime: String,
                @SerialName("date")
                val date: String,
                @SerialName("appointment_id")
                val appointmentId : String,
                @SerialName("service_id")
                val serviceId : String,
                @SerialName("available_slots")
                val availableSlots: Int,
                @SerialName("commercial")
                val commercial: Boolean,
                @SerialName("client_recorded")
                val clientRecorded: Boolean,
                @SerialName("is_cancelled")
                val isCancelled: Boolean,
                @SerialName("tab")
                val tab: String,
                @SerialName("color")
                val color: String,
                @SerialName("tab_id")
                val tabId: Int
            )
        }
    }
}