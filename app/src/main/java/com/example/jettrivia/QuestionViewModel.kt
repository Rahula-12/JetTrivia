package com.example.jettrivia

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.model.QuestionItem
import com.example.jettrivia.repository.QuestionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val questionsRepository: QuestionsRepository):ViewModel(){
    private val _dataOrException=MutableStateFlow<DataOrException<ArrayList<QuestionItem>,Boolean,Exception>>(DataOrException())
     val dataOrException:StateFlow<DataOrException<ArrayList<QuestionItem>,Boolean,Exception>> = _dataOrException

    init {
        getAllQuestions()
        Log.d("viewData",dataOrException.value.data.toString())
    }

    private fun getAllQuestions() {
        viewModelScope.launch{
                _dataOrException.update {
                    it.copy(
                        loading = true,
                        data = questionsRepository.getAllQuestions().data
                    )
                }
        }
    }

}