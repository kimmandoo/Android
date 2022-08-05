package com.kimmandoo.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizModel"

class QuizViewModel: ViewModel() {
    //initialize block
    init {
        Log.d(TAG, "Viewmodel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"Viewmodel instance about to be destroyed")
    }

    private val questionBank = listOf(
        Question(R.string.question_asia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_australia, true)
    )

    val currentQuestionAnswer get() = questionBank[currentIndex].answer
    val currentQuestionText get() = questionBank[currentIndex].textResId
    fun moveToNext(){
        currentIndex = (currentIndex + 1)% questionBank.size
    }

    var currentIndex = 0
}