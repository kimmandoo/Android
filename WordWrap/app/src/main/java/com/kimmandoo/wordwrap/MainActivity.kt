package com.kimmandoo.wordwrap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView =  findViewById<TextView>(R.id.test)
        textView.text = getString(R.string.test).replace(" ", "\u00A0")
    }
}