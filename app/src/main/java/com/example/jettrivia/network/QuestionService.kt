package com.example.jettrivia.network

import com.example.jettrivia.model.Question
import retrofit2.http.GET

interface QuestionService {
    @GET("world.json")
    suspend fun questionAnswers():Question

}