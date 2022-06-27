package com.kimmandoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kimmandoo.databinding.ActivityCommentBinding
import com.kimmandoo.databinding.ActivityMainBinding
import com.kimmandoo.databinding.ActivityUploadBinding

class CommentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCommentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}