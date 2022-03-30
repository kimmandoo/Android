package com.tistory.gyudev.lec1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img1 = findViewById<ImageView>(R.id.bts_1)

        val intent = Intent(this, ImageActivity::class.java)

        img1.setOnClickListener {
            Toast.makeText(this, "bts1_Clicked", Toast.LENGTH_SHORT).show()

            startActivity(intent)
        }

    }
}