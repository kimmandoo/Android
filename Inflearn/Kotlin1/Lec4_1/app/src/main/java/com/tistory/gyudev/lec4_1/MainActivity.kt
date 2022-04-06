package com.tistory.gyudev.lec4_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tistory.gyudev.lec4_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sentenceList = mutableListOf<String>()
        sentenceList.add("Life is boiled egg")
        sentenceList.add("Life is boiling egg")
        sentenceList.add("Life is egg")
        sentenceList.add("Life is egg egg")
        sentenceList.add("Life is fire egg")
        sentenceList.add("Life is half boiled egg")
        sentenceList.add("Life is fried egg")
        sentenceList.add("Life is ripen egg")
        sentenceList.add("Life is raw egg")

//        sentenceList.random()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btn.setOnClickListener {
            val intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
//            intent.putExtra("sentenceList", sentenceList)
        }

//        var getMsg: String? = intent.getStringExtra("msg")
//        if(getMsg == null){
//            getMsg = sentenceList.random()
//        }
        binding.textView.text = sentenceList.random()
    }
}