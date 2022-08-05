package com.kimmandoo.exoplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kimmandoo.exoplayer.databinding.ActivityContainerBinding
import com.kimmandoo.exoplayer.version2.ExoFragment

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