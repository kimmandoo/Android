package com.kimmandoo.joyce.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.kimmandoo.joyce.R
import com.kimmandoo.joyce.databinding.FragmentQuestionBinding
import com.kimmandoo.joyce.databinding.FragmentSelectBinding

class SelectFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentSelectBinding? = null
    private val binding get() = _binding!!

    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.selectTv1.setOnClickListener(this)
        binding.selectTv2.setOnClickListener(this)
        binding.selectTv3.setOnClickListener(this)
        binding.selectTv4.setOnClickListener(this)
        binding.selectIvBack.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.select_tv_1 -> {
                navWithIndex(1)
            }
            R.id.select_tv_2 -> {
                navWithIndex(2)
            }
            R.id.select_tv_3 -> {
                navWithIndex(3)
            }
            R.id.select_tv_4 -> {
                navWithIndex(4)
            }
            R.id.select_iv_back -> {
//                navController.navigate(R.id.action_selectFragment_to_questionFragment)
                navController.popBackStack()
                //because fragment is stack type
            }
        }
    }
    fun navWithIndex(index: Int){
        val bundle = bundleOf("index" to index)
        //bundle을 같이 넣어줌
        navController.navigate(R.id.action_selectFragment_to_resultFragment, bundle)
    }
}