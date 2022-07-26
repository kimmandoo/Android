package com.kimmandoo.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.kimmandoo.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnTrue.setOnClickListener {
            //api30 over decreaped
            val toast = Toast.makeText(this, R.string.toast_o, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER_VERTICAL,100,0)
            toast.show()
        }

        binding.btnFalse.setOnClickListener {
            Toast.makeText(this, R.string.toast_x, Toast.LENGTH_SHORT).show()
        }
    }
}