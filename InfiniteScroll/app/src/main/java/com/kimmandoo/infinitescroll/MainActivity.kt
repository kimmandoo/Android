package com.kimmandoo.infinitescroll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kimmandoo.infinitescroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var page = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}