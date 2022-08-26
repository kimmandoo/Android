package com.kimmandoo.project_exercise_3_2.feature4

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kimmandoo.project_exercise_3_2.MainActivity
import com.kimmandoo.project_exercise_3_2.R
import com.kimmandoo.project_exercise_3_2.databinding.ActivityAlertViewBinding

class AlertViewActivity : AppCompatActivity() {
    val binding by lazy { ActivityAlertViewBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val title = intent.getStringExtra("title")
        val detail = intent.getStringExtra("detail")

        binding.alarmTitle.text = title
        binding.alarmDetail.text = detail

        binding.btnGomain.setOnClickListener {
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}