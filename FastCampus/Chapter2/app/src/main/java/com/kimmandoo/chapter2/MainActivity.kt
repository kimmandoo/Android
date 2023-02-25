package com.kimmandoo.chapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv)
        val resetBtn = findViewById<Button>(R.id.btn_reset)
        val plusBtn = findViewById<Button>(R.id.btn_plus)

        var number = 0
        resetBtn.setOnClickListener {
            number = 0
            tv.text = number.toString()
        }

        plusBtn.setOnClickListener {
            number++
            tv.text = number.toString()
        }
    }
}