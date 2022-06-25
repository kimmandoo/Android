package com.kimmandoo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimmandoo.databinding.ItemHomeFeedBinding
import com.kimmandoo.databinding.ItemHomeStoryBinding

class StoryAdapter (private val context: MainActivity, private val dataList: ArrayList<Story>) :
    RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemHomeStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, item: Story) {
            binding.storyTvUserId.text = item.userId

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeStoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}