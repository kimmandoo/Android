package com.kimmandoo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kimmandoo.databinding.FragmentHeartBinding
import com.kimmandoo.databinding.FragmentMainBinding

class HeartFragment : Fragment() {

    private var _binding: FragmentHeartBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHeartBinding.inflate(inflater, container, false)
        return binding.root
    }
}