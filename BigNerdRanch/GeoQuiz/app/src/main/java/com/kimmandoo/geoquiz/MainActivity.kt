package com.kimmandoo.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.kimmandoo.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val questionBank = listOf(
        Question(R.string.question_asia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_australia, true)
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
        updateQuestion()
    }
    //공통된 건 함수로 뺀다.
    private fun updateQuestion(){
        val questionTextResId = questionBank[currentIndex].textResId
        // setText는 resId를 인자로 받을 수 있다.
        binding.tvQuestion.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if(userAnswer == correctAnswer){
            R.string.toast_o
        }else{
            R.string.toast_x
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}