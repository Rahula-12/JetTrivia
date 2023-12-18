package com.example.jettrivia.data

import com.example.jettrivia.model.Question
import retrofit2.http.GET

interface QuestionService {
    @GET("world.json")
    fun questionAnswers():Question

}