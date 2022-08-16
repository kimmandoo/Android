package com.kimmandoo.project_exercise_3_2.feature3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kimmandoo.project_exercise_3_2.R
import com.kimmandoo.project_exercise_3_2.databinding.FragmentFeatureTwoTwoBinding
import com.kimmandoo.project_exercise_3_2.databinding.FragmentRoomBinding

class RoomFragment : Fragment() {
    private var _binding: FragmentRoomBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRoomBinding.inflate(inflater, container, false)
        return binding.root
    }
}