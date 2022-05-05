package com.tistory.gyudev.lec6_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class Splash : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth

        try{

            Log.d("Splash", auth.currentUser!!.uid)
            Toast.makeText(baseContext, "비회원 가입된 사람입니다",
                Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
            },1500)

        }catch (e:Exception){
            Log.d("Splash", "need to sign in")

            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(baseContext, "비회원 로그인 성공.",
                            Toast.LENGTH_SHORT).show()
                        val user = auth.currentUser

                        Handler().postDelayed({
                            startActivity(Intent(this, MainActivity::class.java))
                        },1500)

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "비회원 로그인 실패.",
                            Toast.LENGTH_SHORT).show()
                    }
                }

        }

    }
}