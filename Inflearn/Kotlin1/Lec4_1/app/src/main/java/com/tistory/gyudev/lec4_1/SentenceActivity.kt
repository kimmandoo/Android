package com.tistory.gyudev.lec4_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.databinding.DataBindingUtil

class SentenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)

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
        sentenceList.add("Life is boiled egg")
        sentenceList.add("Life is boiling egg")
        sentenceList.add("Life is egg")
        sentenceList.add("Life is egg egg")
        sentenceList.add("Life is fire egg")
        sentenceList.add("Life is half boiled egg")
        sentenceList.add("Life is fried egg")
        sentenceList.add("Life is ripen egg")
        sentenceList.add("Life is raw egg")
        //실전이었으면 sql에서 가져왔을 것.

        val listAdapter = ListViewAdapter(sentenceList)

        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = listAdapter

    }
}