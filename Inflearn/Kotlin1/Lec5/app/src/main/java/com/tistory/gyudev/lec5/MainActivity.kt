package com.tistory.gyudev.lec5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<String>()
        items.add("A")
        items.add("Bc")
        items.add("CD")
        items.add("A")
        items.add("Bc")
        items.add("CD")
        items.add("A")
        items.add("Bc")
        items.add("CD")
        items.add("A")
        items.add("Bc")
        items.add("CD")
        items.add("A")
        items.add("Bc")
        items.add("CD")

        val rv = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RecyclerAdapter(items)
        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)

        rvAdapter.itemClick = object : RecyclerAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                Toast.makeText(baseContext, items[position], Toast.LENGTH_SHORT).show()
            }
        }

    }
}