package com.tistory.gyudev.lec4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ListView
import android.widget.Toast

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
        //nullable 변수에 null 넣어주기. ?는 null일수있음 !는 null이 아님
        val nullTest :String? = null

        val listAdapter = ListViewAdapter(testList)

        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = listAdapter


    }

    private var doubleClicked = false

    override fun onBackPressed() {
//        super.onBackPressed()
        Log.d("Main", "Back pressed")
        if (doubleClicked == true){
            finish()
        }
        doubleClicked = true
        Toast.makeText(this, "Click one more to exit",Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable {
            doubleClicked = false
        },1000)
    }
}