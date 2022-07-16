package com.kimmandoo.dating.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kimmandoo.dating.R
import com.kimmandoo.dating.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    val binding by lazy { ActivityIntroBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.introBtnJoin.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

    }
}