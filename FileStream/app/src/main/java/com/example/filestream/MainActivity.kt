package com.example.filestream

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textField = findViewById<EditText>(R.id.textField)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnLoad = findViewById<Button>(R.id.btnLoad)

        val filename = "data.txt"

        btnSave.setOnClickListener {
            val text = textField.text.toString()

            saveFile(text, filename)
        }

        btnLoad.setOnClickListener {
            textField.setText(loadFile(filename))
        }
    }

    fun saveFile(text: String, filename: String){
        val fos = openFileOutput(filename, MODE_PRIVATE)
        fos.write(text.toByteArray())

        fos.close()
    }

    fun loadFile(filename: String): String{
        val fis = openFileInput(filename)
        return fis.reader().readText()
    }
}