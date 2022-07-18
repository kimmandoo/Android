package com.kimmandoo.dating.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.kimmandoo.dating.MainActivity
import com.kimmandoo.dating.R
import com.kimmandoo.dating.utils.FirebaseAuthUtils

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val uid = FirebaseAuthUtils.getUid()
        Handler(Looper.getMainLooper()).postDelayed({
            Log.d("Splash",FirebaseAuthUtils.getUid())
            if (uid == "null") {
                val intent = Intent(baseContext, IntroActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(baseContext, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
                finish()
            }

        }, 400)
    }
}