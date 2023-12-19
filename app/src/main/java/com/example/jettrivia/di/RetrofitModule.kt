package com.example.jettrivia.di

import com.example.jettrivia.network.QuestionService
import com.example.jettrivia.repository.QuestionsRepository
import com.example.jettrivia.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @Singleton
    @Provides
    fun providesQuestionService(): QuestionService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(
            QuestionService::class.java
        )
    }

    @Singleton
    @Provides
    fun providesQuestionsRepository(api:QuestionService):QuestionsRepository{
        return QuestionsRepository(api)
    }

}