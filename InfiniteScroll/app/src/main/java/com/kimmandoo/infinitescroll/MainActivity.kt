package com.kimmandoo.infinitescroll

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kimmandoo.infinitescroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var isLoading = false
    private val testItems = mutableListOf<String?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        for(i in 1 until 10){
            testItems.add("dummy item $i")
        }
//        null test
//        testItems.add(null)
        binding.rv.layoutManager = LinearLayoutManager(baseContext)
        binding.rv.adapter = RvAdapter(testItems)
        binding.rv.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = binding.rv.layoutManager as LinearLayoutManager
//                if(!isLoading){
//                    if(layoutManager != null && layoutManager.findLastCompletelyVisibleItemPosition() == testItems.size - 1){
//                        isLoading = true
//                        getMoreData()
//                    }
//                }
                if(!isLoading){
                    if(!binding.rv.canScrollVertically(1)){
                        isLoading = true
                        getMoreData()
                    }
                }
            }
        })

    }

    private fun getMoreData() {
        testItems.add(null)
        binding.rv.adapter?.notifyItemInserted(testItems.size - 1)
        testItems.removeAt(testItems.size - 1)
        val currentSize = testItems.size
        for(i in currentSize+1 until currentSize+10){
            testItems.add("dummy item $i")
        }
        binding.rv.adapter?.notifyDataSetChanged()
        isLoading = false
    }
}