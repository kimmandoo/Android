package com.kimmandoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kimmandoo.databinding.ActivityMainBinding
import com.kimmandoo.databinding.ActivityUploadBinding

class UploadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUploadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}