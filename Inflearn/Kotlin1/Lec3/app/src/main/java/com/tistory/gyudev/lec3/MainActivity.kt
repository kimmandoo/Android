package com.tistory.gyudev.lec3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.tistory.gyudev.lec3.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    //databinding code
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val btnGO = findViewById<Button>(R.id.btnGo)
//        val dice1 = findViewById<ImageView>(R.id.dice1)
//        val dice2 = findViewById<ImageView>(R.id.dice2)
//
//        btnGO.setOnClickListener {
//
//        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnGo.setOnClickListener {
            Log.d("Main", "btn clicked")

            val diceOne = Random.nextInt(1, 6)
            val diceTwo = Random.nextInt(1, 6)

            if (diceOne == 1) {
                binding.dice1.setImageResource(R.drawable.dice_1)
            } else if (diceOne == 2) {
                binding.dice1.setImageResource(R.drawable.dice_2)
            } else if (diceOne == 3) {
                binding.dice1.setImageResource(R.drawable.dice_3)
            } else if (diceOne == 4) {
                binding.dice1.setImageResource(R.drawable.dice_4)
            } else if (diceOne == 5) {
                binding.dice1.setImageResource(R.drawable.dice_5)
            } else {
                binding.dice1.setImageResource(R.drawable.dice_6)
            }

            when (diceTwo) {
                1 -> {
                    binding.dice2.setImageResource(R.drawable.dice_1)
                }
                2 -> {
                    binding.dice2.setImageResource(R.drawable.dice_2)
                }
                3 -> {
                    binding.dice2.setImageResource(R.drawable.dice_3)
                }
                4 -> {
                    binding.dice2.setImageResource(R.drawable.dice_4)
                }
                5 -> {
                    binding.dice2.setImageResource(R.drawable.dice_5)
                }
                else -> {
                    binding.dice2.setImageResource(R.drawable.dice_6)
                }
            }


//            val src1 = "R.drawable.$diceOne"
//            val src2 = "R.drawable.$diceTwo"
//            binding.dice1.setImageResource(Integer.parseInt(src1))
//            binding.dice1.setImageResource(Integer.parseInt(src2))


        }

//
//        val btn = findViewById<Button>(R.id.testBtnId)
//        //값을 중간에 바꾼다면 var(변수), 안바꾸면 val(상수)
//        //제일 기본적인 방식
//        btn.setOnClickListener {
//            Toast.makeText(this,"test",Toast.LENGTH_SHORT).show()
//
//        }
//        //data binding
//        //findViewById를 처리하지않아도 layout파일에서 바로 처리가능함.
//        binding.testBtnId.setOnClickListener {
//            Toast.makeText(this,"test",Toast.LENGTH_SHORT).show()
//        }


    }
}