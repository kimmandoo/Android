package com.tistory.gyudev.lec7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Splash : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        auth = Firebase.auth
//        var intent: Intent? = null
        if(auth.currentUser?.uid == null){
            //회원가입 필요함. -> join activity
//            intent = Intent(this, LoginActivity::class.java)
            Toast.makeText(this, "회원가입이 필요합니다", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            },2000)
        }else{
            //이미 가입된 회원 -> main activity
//            intent = Intent(this, MainActivity::class.java)
            Toast.makeText(this, "환영합니다", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            },2000)
        }

//        auth.signInAnonymously()
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    val user = auth.currentUser
//                } else {
//                    // If sign in fails, display a message to the user.
//                }
//            }



    }
}