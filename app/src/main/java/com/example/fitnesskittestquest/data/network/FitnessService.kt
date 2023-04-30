package com.example.fitnesskittestquest.data.network

import com.example.fitnesskittestquest.data.network.models.FitnessResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FitnessService {

    @GET("schedule/get_v3/")
    suspend fun getInfo(
        @Query("club_id") club_id: String = "2"
    ): FitnessResponse
}