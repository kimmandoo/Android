package com.kimmandoo.joyce.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.kimmandoo.joyce.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    var option = -1
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater, container, false)

        option = arguments?.getInt("index", -1)?:-1
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        setResult(option)
    }

    private fun setResult(option: Int) {
        when(option){
            1 ->{
                binding.mainTv.text="You are a Quitter"
                binding.subTv.text="You can let the person easily"
            }
            2 ->{
                binding.mainTv.text="You should focus on yourself"
                binding.subTv.text="You become really clingy to your ex"
            }
            3 ->{
                binding.mainTv.text="You should take it easy"
                binding.subTv.text="You can do crazy things no matter what it takes"
            }
            4 ->{
                binding.mainTv.text="You are pretty mature"
                binding.subTv.text="You can easily accept the break-up"
            }
        }
    }
}