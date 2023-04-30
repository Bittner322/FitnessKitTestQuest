package com.example.fitnesskittestquest.di

import com.example.fitnesskittestquest.data.network.FitnessService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {

    private val contentType = "application/json".toMediaType()

    @Provides
    @Singleton
    fun provideJsonFactory(): Json {
        return Json {
            prettyPrint = false
            isLenient = true
            ignoreUnknownKeys = true
            coerceInputValues = true
            encodeDefaults = true
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(json: Json): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://olimpia.fitnesskit-admin.ru/")
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideFitnessService(retrofit: Retrofit): FitnessService {
        return retrofit.create()
    }
}