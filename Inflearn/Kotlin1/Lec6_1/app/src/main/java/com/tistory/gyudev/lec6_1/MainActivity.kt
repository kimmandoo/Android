package com.tistory.gyudev.lec6_1

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth

        val btnJoin = findViewById<Button>(R.id.btnJoin)

        btnJoin.setOnClickListener {
            val email = findViewById<EditText>(R.id.id)
            val pw = findViewById<EditText>(R.id.pw)

            //이미 firebase상에 존재하는 이메일로는 중복가입이 불가능하다.

            Log.d("Main", "id: "+email.text.toString()+"  pw: "+pw.text.toString())
            auth.createUserWithEmailAndPassword(email.text.toString(), pw.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        Toast.makeText(baseContext, "Authentication successed.",
                            Toast.LENGTH_SHORT).show()
                        Log.d("MainActivity", user!!.uid)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val email = findViewById<EditText>(R.id.id)
            val pw = findViewById<EditText>(R.id.pw)

            auth.signInWithEmailAndPassword(email.text.toString(), pw.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser

                        Toast.makeText(baseContext, "Login successed",
                            Toast.LENGTH_SHORT).show()

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Login failed.",
                            Toast.LENGTH_SHORT).show()

                    }
                }
        }

        val btnLogout = findViewById<Button>(R.id.btnLogOut)
        btnLogout.setOnClickListener {
            Firebase.auth.signOut()
            Toast.makeText(this, "sign out success", Toast.LENGTH_SHORT).show()
        }

    }
}