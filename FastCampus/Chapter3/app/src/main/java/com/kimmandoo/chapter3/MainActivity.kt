package com.kimmandoo.chapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.core.widget.addTextChangedListener
import com.kimmandoo.chapter3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var cmToM = true
    var inputNumber: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val input = binding.mainEt
        val imgSwap = binding.imgSwap
        val inputUnit = binding.mainTvCm
        val outputUnit = binding.mainTvM
        val output = binding.outputTv


        imgSwap.setOnClickListener {
            cmToM = cmToM.not()
            if (cmToM) {
                inputUnit.text = "cm"
                outputUnit.text = "m"
                output.text = inputNumber.times(0.01).toString()
            } else {
                inputUnit.text = "m"
                outputUnit.text = "cm"
                output.text = inputNumber.times(100).toString()
            }
        }

        input.addTextChangedListener { text ->
            //예외처리하기 try-catch, try-catch-finally

            inputNumber = if (text.isNullOrEmpty()) {
                0
            } else {
                text.toString().toInt()
            }
            if(cmToM){
                output.text = inputNumber.times(0.01).toString()
            }else{
                output.text = inputNumber.times(100).toString()
            }
            var outputNumber = inputNumber.times(0.01)
            output.text = outputNumber.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("cmToM", cmToM)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        cmToM = savedInstanceState.getBoolean("cmToM")
        binding.mainTvCm.text = if(cmToM) "cm" else "m"
        binding.mainTvM.text = if(cmToM) "m" else "cm"
        super.onRestoreInstanceState(savedInstanceState)
    }
    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}