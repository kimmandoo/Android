package com.kimmandoo

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.kimmandoo.databinding.ItemHomeFeedBinding

class FeedAdapter(private val context: MainActivity, private val dataList: ArrayList<Feed>) :
    RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    private lateinit var database: DatabaseReference
    inner class ViewHolder(private val binding: ItemHomeFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, item: Feed, dbIndex: Int) {
            binding.feedTvUserId.text = item.userId

            Glide.with(context)
                .load(item.profileImageUrl)
                .into(binding.feedIvProfile)

            Glide.with(context)
                .load(item.imageUrl)
                .into(binding.feedIvImage)

            binding.feedIvProfile.background = ShapeDrawable(OvalShape())
            binding.feedIvProfile.clipToOutline = true

            val db = Firebase.database
            database = db.getReference("FeedList")

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
                    database.child(dbIndex.toString()).child("likeCount").setValue(item.likeCount)

                }else{
                    binding.feedBtnHeart.setImageResource(R.drawable.ic_heart_on)
                    item.isLike = true
                    item.likeCount = item.likeCount + 1

                    database.child(dbIndex.toString()).child("likeCount").setValue(item.likeCount)

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
        holder.bind(context, dataList[position], position+1)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}