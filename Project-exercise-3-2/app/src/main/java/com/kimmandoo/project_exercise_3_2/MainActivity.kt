package com.kimmandoo.project_exercise_3_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.kimmandoo.project_exercise_3_2.databinding.ActivityMainBinding
import com.kimmandoo.project_exercise_3_2.feature1.FeatureOneFragment
import com.kimmandoo.project_exercise_3_2.feature1.FeatureOneViewModel
import com.kimmandoo.project_exercise_3_2.feature2.FeatureTwoFragment
import com.kimmandoo.project_exercise_3_2.feature2.FeatureTwoTwoFragment
import com.kimmandoo.project_exercise_3_2.feature3.RoomFragment
import com.kimmandoo.project_exercise_3_2.feature4.AlertFragment

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private var container = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        container = binding.container.id

        binding.btnFun1.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(container, FeatureOneFragment()).commitAllowingStateLoss()
        }
        binding.btnFun2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(container, FeatureTwoTwoFragment()).commitAllowingStateLoss()
        }
        binding.btnFun3.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(container, RoomFragment()).commitAllowingStateLoss()
        }
        binding.btnFun4.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(container, AlertFragment()).commitAllowingStateLoss()
        }

    }
}