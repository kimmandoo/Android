package com.kimmandoo.infinitescroll.Poops

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimmandoo.infinitescroll.databinding.RvItemBinding

class RecyclerViewAdapterSecond(private val items: ArrayList<String>) : RecyclerView.Adapter<RecyclerViewAdapterSecond.ViewHolder>(){
    inner class ViewHolder(val binding: RvItemBinding):RecyclerView.ViewHolder(binding.root){
        fun setItem(item: String){
            with(binding){
                binding.rvItemTv.text = item
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when (viewType) {
            0 -> {}
        }
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return if (item != null) {
            1
        }else{
            0
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}