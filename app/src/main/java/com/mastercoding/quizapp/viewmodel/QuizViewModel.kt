package com.mastercoding.quizapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mastercoding.quizapp.model.QuestionsList
import com.mastercoding.quizapp.repository.QuizRepository

class QuizViewModel : ViewModel() {
    var repository : QuizRepository = QuizRepository()

    lateinit var questionsLiveData: LiveData<QuestionsList>

    init {
        questionsLiveData = repository.getQuestionsFromAPI()
    }

    fun getQuestionsFromLiveData(): LiveData<QuestionsList>{
        return questionsLiveData
    }

}