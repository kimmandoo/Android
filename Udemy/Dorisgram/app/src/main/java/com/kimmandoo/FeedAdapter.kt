package com.kimmandoo

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimmandoo.databinding.ItemHomeFeedBinding

class FeedAdapter(private val context: MainActivity, private val dataList: ArrayList<Feed>) :
    RecyclerView.Adapter<FeedAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemHomeFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, item: Feed) {
            binding.feedTvUserId.text = item.userId
            var likeCount = StringBuilder()
            likeCount.append(context.resources.getString(R.string.home_like_count_before))
                .append(item.likeCount)
                .append(context.resources.getString(R.string.home_like_count_after))
            binding.feedTvLikeCount.text = likeCount
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeFeedBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}