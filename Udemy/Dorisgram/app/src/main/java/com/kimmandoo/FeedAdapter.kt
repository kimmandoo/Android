package com.kimmandoo

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kimmandoo.databinding.ItemHomeFeedBinding

class FeedAdapter(private val context: MainActivity, private val dataList: ArrayList<Feed>) :
    RecyclerView.Adapter<FeedAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemHomeFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, item: Feed) {
            binding.feedTvUserId.text = item.userId

            Glide.with(context)
                .load(item.profileImageUrl)
                .into(binding.feedIvProfile)

            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.feedIvImage)

            binding.feedIvProfile.background = ShapeDrawable(OvalShape())
            binding.feedIvProfile.clipToOutline = true

            var likeCount = StringBuilder()
            likeCount.append(context.resources.getString(R.string.home_like_count_before))
                .append(item.likeCount)
                .append(context.resources.getString(R.string.home_like_count_after))
            binding.feedTvLikeCount.text = likeCount
            //좋아요 버튼
            binding.feedBtnHeart.setOnClickListener {
                if(item.isLike){
                    binding.feedBtnHeart.setImageResource(R.drawable.ic_heart_off)
                    item.isLike = false
                    item.likeCount = item.likeCount - 1
                }else{
                    binding.feedBtnHeart.setImageResource(R.drawable.ic_heart_on)
                    item.isLike = true
                    item.likeCount = item.likeCount + 1
                }
                var likeCount = StringBuilder()
                likeCount.append(context.resources.getString(R.string.home_like_count_before))
                    .append(item.likeCount)
                    .append(context.resources.getString(R.string.home_like_count_after))
                binding.feedTvLikeCount.text = likeCount
            }

            binding.feedBtnBookmark.setOnClickListener {
                if(item.isBookmark){
                    binding.feedBtnBookmark.setImageResource(R.drawable.ic_bookmark_off)
                    item.isBookmark = false
                }else{
                    binding.feedBtnBookmark.setImageResource(R.drawable.ic_bookmark_on)
                    item.isBookmark = true
                }
            }

            binding.feedBtnComment.setOnClickListener {
                Intent(context, CommentActivity::class.java).apply {
                    //같이 넘겨줄 데이터 들
                }.run {
                    context.startActivity(this)
                }

            }
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