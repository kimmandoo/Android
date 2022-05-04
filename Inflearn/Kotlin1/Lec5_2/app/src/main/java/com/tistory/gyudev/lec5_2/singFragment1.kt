package com.tistory.gyudev.lec5_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class singFragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sing1, container, false)

        //Recycler View 연결

        val items = mutableListOf<String>()

        items.add("노래1")
        items.add("노래2")
        items.add("노래3")
        items.add("노래1")
        items.add("노래2")
        items.add("노래3")
        items.add("노래1")
        items.add("노래2")
        items.add("노래3")
        items.add("노래1")
        items.add("노래2")
        items.add("노래3")
        items.add("노래1")
        items.add("노래2")
        items.add("노래3")

        val rv = view.findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RvAdapter(items)
        rv.adapter = rvAdapter

        rv.layoutManager = LinearLayoutManager(context)

        view.findViewById<ImageView>(R.id.sing2).setOnClickListener {
            it.findNavController().navigate(R.id.action_singFragment1_to_singFragment2)
        }
        view.findViewById<ImageView>(R.id.sing3).setOnClickListener {
            it.findNavController().navigate(R.id.action_singFragment1_to_singFragment3)
        }

        return view
    }


}