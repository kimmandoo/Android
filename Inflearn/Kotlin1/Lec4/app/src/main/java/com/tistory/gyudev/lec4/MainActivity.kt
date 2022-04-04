package com.tistory.gyudev.lec4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testList2 = mutableListOf<ListViewModel>()
        testList2.add(ListViewModel("a","b"))
        testList2.add(ListViewModel("c","d"))
        testList2.add(ListViewModel("e","f"))

        val testList = mutableListOf<String>()
        testList.add("a")
        testList.add("b")
        testList.add("c")

        val listAdapter = ListViewAdapter(testList)

        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = listAdapter
    }
}