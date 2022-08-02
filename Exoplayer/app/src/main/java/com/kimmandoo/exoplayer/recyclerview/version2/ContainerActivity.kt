package com.kimmandoo.exoplayer.recyclerview.version2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kimmandoo.exoplayer.R
import com.kimmandoo.exoplayer.databinding.ActivityContainerBinding

class ContainerActivity : AppCompatActivity() {
    val binding by lazy {ActivityContainerBinding.inflate(layoutInflater)}
    private var container = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        container = binding.container.id
        supportFragmentManager.beginTransaction().replace(container, ExoFragment()).commitAllowingStateLoss()
    }
}