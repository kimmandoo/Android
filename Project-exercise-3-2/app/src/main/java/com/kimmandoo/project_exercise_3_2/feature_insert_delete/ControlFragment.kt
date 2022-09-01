package com.kimmandoo.project_exercise_3_2.feature_insert_delete

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kimmandoo.project_exercise_3_2.R
import com.kimmandoo.project_exercise_3_2.databinding.FragmentControlBinding
import com.kimmandoo.project_exercise_3_2.databinding.FragmentRoomExpBinding

class ControlFragment : Fragment() {
    private var _binding: FragmentControlBinding? = null
    private val binding get() = _binding!!

    lateinit var date: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentControlBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            var day: String = ""
            if (month > 8){
                day = if (dayOfMonth < 9) {
                    "0$dayOfMonth"
                }else{
                    "$dayOfMonth"
                }
                date = "$year-${month+1}-$day"
            }else{
                day = if (dayOfMonth < 9){
                    "0$dayOfMonth"
                }else{
                    "$dayOfMonth"
                }
                date = "$year-0${month+1}-$day"
            }

            Log.d("date","$date")
            //여기서 받은 date를 입력하면 됨.
        }
    }
}