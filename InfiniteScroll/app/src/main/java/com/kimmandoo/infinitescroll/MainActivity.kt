package com.kimmandoo.infinitescroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kimmandoo.infinitescroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var page = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val items = arrayListOf<String>(
            "this",
            "this is ",
            "this is good",
            "this",
            "this is ",
            "this is good",
            "this",
            " ",
            "this is good",
            "this",
            "this is ",
            "this is good",
            "this",
            "this is ",
            "this is good",
            "this",
            "this is ",
            "this is good",
            "this",
            "this is ",
            "this is good",
            "this",
            "this is ",
            "this is good",
            "this",
            "this is ",
            "this is good",
        )
        val rvAdapter = RecyclerViewAdapter()
        rvAdapter.setList(items)

        binding.rv.apply {
            rvAdapter.notifyItemRangeInserted((page - 1) * 10, 10)
            binding.rv.layoutManager = LinearLayoutManager(context)
            binding.rv.adapter = rvAdapter
        }

        binding.rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val lastVisibleItemPosition =
                    (recyclerView.layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
                val itemTotalCount = recyclerView.adapter!!.itemCount - 1

                if (!binding.rv.canScrollVertically(1) && lastVisibleItemPosition == itemTotalCount) {
                    RecyclerViewAdapter().deleteLoading()
                    rvAdapter.notifyDataSetChanged()
                }
            }
        })

    }
}