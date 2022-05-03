package com.tistory.gyudev.lec5_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [singFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class singFragment2 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sing2, container, false)

        view.findViewById<ImageView>(R.id.sing1).setOnClickListener {
            it.findNavController().navigate(R.id.action_singFragment2_to_singFragment1)
        }
        view.findViewById<ImageView>(R.id.sing3).setOnClickListener {
            it.findNavController().navigate(R.id.action_singFragment2_to_singFragment3)
        }

        return view
    }
}