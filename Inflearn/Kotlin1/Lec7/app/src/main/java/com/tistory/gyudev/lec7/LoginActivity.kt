package com.tistory.gyudev.lec7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val editTextId = findViewById<EditText>(R.id.id)
        val editTextPw = findViewById<EditText>(R.id.pw)

        btnLogin.setOnClickListener {
            val email = editTextId.text.toString()
            val password = editTextPw.text.toString()
            if(email.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "정보를 입력하세요", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = auth.currentUser
                            Log.d("MainAcitivty",""+user?.uid)
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(this, "비밀번호가 너무 짧습니다", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}