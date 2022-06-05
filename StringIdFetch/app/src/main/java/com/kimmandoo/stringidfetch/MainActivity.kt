package com.kimmandoo.stringidfetch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textId = resources.getIdentifier("hello","id",packageName)
        val helloWorld = findViewById<TextView>(textId)

        helloWorld.setOnClickListener {
            Toast.makeText(this, "id fetched", Toast.LENGTH_SHORT).show()
        }
    }
}