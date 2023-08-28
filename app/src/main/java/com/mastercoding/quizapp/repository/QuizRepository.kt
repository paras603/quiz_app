package com.mastercoding.quizapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mastercoding.quizapp.model.QuestionsList
import com.mastercoding.quizapp.retrofit.QuestionsAPI
import com.mastercoding.quizapp.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuizRepository {

    var questionsAPI: QuestionsAPI

    init{
        questionsAPI = RetrofitInstance().getRetrofitInstance()
            .create(QuestionsAPI::class.java)
    }

    //Live data
    fun getQuestionsFromAPI(): LiveData<QuestionsList>{
        var data = MutableLiveData<QuestionsList>()

        var questionsList : QuestionsList

        GlobalScope.launch(Dispatchers.IO) {
            //returning the Response<QuestionsList>
            val response = questionsAPI.getQuestions()

            if (response != null){
                // saving the data to list
                questionsList = response.body()!!

                data.postValue(questionsList)
                Log.i("TAGY", ""+data.value)
            }
        }
    return data
    }

}