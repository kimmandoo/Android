package com.kimmandoo.project_exercise_3_2.feature_room_exp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimmandoo.project_exercise_3_2.databinding.DbItemBinding
import com.kimmandoo.project_exercise_3_2.databinding.ExpdbItemBinding

class ExpDBAdapter(val items: MutableList<RoomExpDB>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemViewHolder(private val binding: ExpdbItemBinding): RecyclerView.ViewHolder(binding.root){
        fun setItem(item: RoomExpDB){
            with(binding){
                expItemName.text = item.name
                expItemCount.text = item.count
                expItemExp.text = item.exp
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ExpdbItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder){
            holder.setItem(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}