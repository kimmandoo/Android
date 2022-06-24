package com.kimmandoo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kimmandoo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.mainBottomNav.itemIconTintList = null // 하트 틴트 자동으로 칠해지던거 없애줌
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.main_frame_layout, HomeFragment()).commitAllowingStateLoss()

        binding.mainBottomNav.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.tab_home ->{
                    supportFragmentManager.beginTransaction().replace(R.id.main_frame_layout, HomeFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.tab_search ->{
                    supportFragmentManager.beginTransaction().replace(R.id.main_frame_layout, SearchFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.tab_upload ->{
                    val intent = Intent(this, UploadActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.tab_heart ->{
                    supportFragmentManager.beginTransaction().replace(R.id.main_frame_layout, HeartFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.tab_mypage ->{
                    supportFragmentManager.beginTransaction().replace(R.id.main_frame_layout, MyPageFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                else -> {
                    false
                }
            }
        }
    }
}