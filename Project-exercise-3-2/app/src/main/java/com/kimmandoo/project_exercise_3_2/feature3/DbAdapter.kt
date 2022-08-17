package com.kimmandoo.project_exercise_3_2.feature3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimmandoo.project_exercise_3_2.databinding.DbItemBinding
import com.kimmandoo.project_exercise_3_2.databinding.ListItemBinding
import com.kimmandoo.project_exercise_3_2.feature1.OneAdapter

class DbAdapter(private val list: MutableList<IngredientDb>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class ItemViewHolder(private val binding: DbItemBinding): RecyclerView.ViewHolder(binding.root){
        val item = binding.listItem

        fun setItem(item: IngredientDb){
            with(binding){
                dbItemTv.text = item.name
                dbItemTvNums.text = item.count
                dbItemTvExp.text = item.exp
            }
        }
    }

    interface ItemClick{
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null
    var minusClick : ItemClick? = null
    var plusClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DbItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ItemViewHolder){
            if(itemClick != null){
                holder.item.setOnClickListener{v->
                    itemClick!!.onClick(v, position)

                }
            }
            holder.setItem(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}