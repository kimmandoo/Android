package com.tistory.gyudev.lec5_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController

class singFragment3 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sing3, container, false)

        val sing1 = view.findViewById<ImageView>(R.id.sing1)
        sing1.setOnClickListener {
            it.findNavController().navigate(R.id.action_singFragment3_to_singFragment1)
        }
        view.findViewById<ImageView>(R.id.sing2).setOnClickListener {
            it.findNavController().navigate(R.id.action_singFragment3_to_singFragment2)
        }
        return view
    }
}