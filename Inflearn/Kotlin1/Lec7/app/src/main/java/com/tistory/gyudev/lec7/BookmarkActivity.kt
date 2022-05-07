package com.tistory.gyudev.lec7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val contentModels = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)
        auth = Firebase.auth

        val database = Firebase.database
        val bookmark = database.getReference("url stored")


        val recyclerView = findViewById<RecyclerView>(R.id.rv2)

        val rvadapter = rvAdapter(baseContext, contentModels)
        recyclerView.adapter = rvadapter

        rvadapter.itemClick = object: rvAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {

                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", contentModels[position].url)
                intent.putExtra("image", contentModels[position].titleImageUrl)
                intent.putExtra("title", contentModels[position].titleText)
                startActivity(intent)
            }
        }

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        bookmark
            .child(auth.currentUser!!.uid)
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(dataModel in snapshot.children){
                        Log.d("Datamodel", dataModel.toString())
                        contentModels.add(dataModel.getValue(DataModel::class.java)!!)

                    }
                    rvadapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("Bookmark","DB error")
                }
            })


    }
}