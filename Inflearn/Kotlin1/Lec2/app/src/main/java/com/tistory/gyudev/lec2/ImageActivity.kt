package com.tistory.gyudev.lec2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val img_val = intent.getStringExtra("data")
        val imgView = findViewById<ImageView>(R.id.img)
        if(img_val=="3"){
            imgView.setImageResource(R.drawable.member_3)
        }

    }
}