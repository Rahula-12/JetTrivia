package com.example.jettrivia.repository

import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.model.Question
import com.example.jettrivia.model.QuestionItem
import com.example.jettrivia.network.QuestionService
import javax.inject.Inject

class QuestionsRepository @Inject constructor(private val service: QuestionService) {

    private val dataOrException=DataOrException<ArrayList<QuestionItem>,Boolean,Exception>()

    suspend fun getAllQuestions():DataOrException<ArrayList<QuestionItem>,Boolean,Exception>{
        try{
            //dataOrException.loading=true
            dataOrException.data=service.questionAnswers()
            if(dataOrException.data.toString().isNotEmpty()) dataOrException.loading=false
        }
        catch (e:Exception) {
            dataOrException.exception=e
        }
        return dataOrException
    }

}