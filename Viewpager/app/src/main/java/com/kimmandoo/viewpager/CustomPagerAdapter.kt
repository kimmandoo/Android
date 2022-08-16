package com.kimmandoo.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimmandoo.viewpager.databinding.ItemViewpagerBinding

class CustomPagerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var textList = listOf<String>()

    inner class Holder(val binding: ItemViewpagerBinding): RecyclerView.ViewHolder(binding.root){
        fun setText(text: String){
            binding.tv.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is Holder){
            holder.setText(textList[position])
        }
    }

    override fun getItemCount(): Int {
        return textList.size
    }
}