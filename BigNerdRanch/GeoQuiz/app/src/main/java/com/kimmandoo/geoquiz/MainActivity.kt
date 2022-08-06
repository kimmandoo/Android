package com.kimmandoo.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.kimmandoo.geoquiz.databinding.ActivityMainBinding

private const val KEY_INDEX = "index"

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val TAG = "MainActivity"
    private val quizViewModel by lazy { ViewModelProvider(this).get(QuizViewModel::class.java) }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "SIS")
        outState.putInt(KEY_INDEX, quizViewModel.currentIndex)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val currentIndex = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0


        //viewmodel link code 위에서 lazy 처리함. 인스턴스를 보존하기 위해 늦게 초기화시키는 것. quizViewModel이 사용될 때 까지 초기화시점을 늦춘다.
//        val provider = ViewModelProvider(this)
//        val quizViewModel = provider.get(QuizViewModel::class.java)
//        Log.d(TAG,"Got a QuizViewModel")


        binding.btnTrue.setOnClickListener {
            //api30 over decreaped
//            val toast = Toast.makeText(this, R.string.toast_o, Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.CENTER_VERTICAL, 100, 0)
//            toast.show()
            checkAnswer(true)
        }

        binding.btnFalse.setOnClickListener {
//            Toast.makeText(this, R.string.toast_x, Toast.LENGTH_SHORT).show()
            checkAnswer(false)
        }

        binding.btnNext.setOnClickListener {
//            currentIndex = (currentIndex + 1) % questionBank.size
            quizViewModel.moveToNext()
            updateQuestion()
        }

        binding.btnPrev.setOnClickListener {

//            currentIndex = if(currentIndex - 1 < 0){
//                questionBank.size - 1
//            }else{
//                currentIndex -1
//            }
            updateQuestion()
        }

        updateQuestion()
    }
    //공통된 건 함수로 뺀다.
    private fun updateQuestion(){
//        val questionTextResId = questionBank[currentIndex].textResId
        // setText는 resId를 인자로 받을 수 있다.
        binding.tvQuestion.setText(quizViewModel.currentQuestionText)
    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = if(userAnswer == correctAnswer){
            R.string.toast_o
        }else{
            R.string.toast_x
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}