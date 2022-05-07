package com.tistory.gyudev.lec7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        auth = Firebase.auth

        val webView = findViewById<WebView>(R.id.webView)
        val url = intent.getStringExtra("url").toString()
        webView.loadUrl(url)
        val imageUrl = intent.getStringExtra("image").toString()
        val title = intent.getStringExtra("title").toString()

        val textViewStore = findViewById<TextView>(R.id.textViewStore)

        val database = Firebase.database
        val bookmark = database.getReference("url stored")

        textViewStore.setOnClickListener {
//            val data = DataModel(url, imageUrl, title)
            bookmark
                .child(auth.currentUser!!.uid)
                .push()
                .setValue(DataModel(url, imageUrl, title))
//                .setValue(data)

        }
    }
}