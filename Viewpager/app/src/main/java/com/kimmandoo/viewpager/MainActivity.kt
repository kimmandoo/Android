package com.kimmandoo.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.kimmandoo.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val textList = listOf("viewA","viewB")
        val customAdapter = CustomPagerAdapter()
        customAdapter.textList = textList
        binding.viewPager.adapter = customAdapter
        val tabList = listOf("viewA","viewB")
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            tab.text = tabList[position]
        }.attach()



//viewpager layout version
//        val fragmentList = listOf(FragmentA(),FragmentB())
//        val adapter = ViewpagerAdapter(this)
//        adapter.fragmentList = fragmentList
//
//        binding.viewPager.adapter = adapter

    }
}