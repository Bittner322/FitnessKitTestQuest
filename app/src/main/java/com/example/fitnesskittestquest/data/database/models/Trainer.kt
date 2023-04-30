package com.example.fitnesskittestquest.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Trainers")
data class Trainer(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "full_name") val fullName: String,
    @ColumnInfo(name = "name") val trainer_name: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "position") val position: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "image_url_small") val imageUrlSmall: String,
    @ColumnInfo(name = "image_url_medium") val imageUrlMedium: String,
    @ColumnInfo(name = "description") val description: String
)