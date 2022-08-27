package com.kimmandoo.project_exercise_3_2.feature2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kimmandoo.project_exercise_3_2.MainActivity
import com.kimmandoo.project_exercise_3_2.databinding.ActivityExpItemBinding
import kotlinx.coroutines.*


class ExpItemActivity : AppCompatActivity() {
    val binding by lazy { ActivityExpItemBinding.inflate(layoutInflater) }
    private val featureTwoViewModel by lazy { ViewModelProvider(this).get(FeatureTwoViewModel::class.java) }
    var clicked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val name = intent.getStringExtra("name")
        val count = intent.getStringExtra("count")
        val exp = intent.getStringExtra("exp")
        binding.itemTvName.text = name + "의 유통기간"
        binding.itemTvCount.text = count + "개"
        binding.itemTvExp.text = exp + "까지 보관가능"

        binding.itemIvMinus.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                featureTwoViewModel.retrofitCountDelete(name!!)
                delay(300)
                binding.itemTvCount.text = featureTwoViewModel.ingredientExp[featureTwoViewModel.ingredientExp.size-1].count + "개"
            }
        }
        binding.btnBack.setOnClickListener {
            val outIntent = Intent(
                applicationContext,
                FeatureTwoTwoFragment::class.java
            )
            outIntent.putExtra("ingredientName",name)
            setResult(RESULT_OK, outIntent)
            finish()
        }
    }
}