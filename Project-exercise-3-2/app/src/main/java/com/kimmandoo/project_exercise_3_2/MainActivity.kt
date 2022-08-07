package com.kimmandoo.project_exercise_3_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kimmandoo.project_exercise_3_2.databinding.ActivityMainBinding
import com.kimmandoo.project_exercise_3_2.feature1.FeatureOneFragment

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


    }
}