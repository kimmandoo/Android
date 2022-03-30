package com.tistory.gyudev.lec2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<ImageView>(R.id.m1)

        btn1.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra("data","3")
            startActivity(intent)
        }
    }
}