package com.kimmandoo.infinitescroll

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RvAdapter(val items: MutableList<String?>) : RecyclerView.Adapter<ViewHolder>() {

    companion object {
        const val ITEM = 1
        const val LOADING = 0
    }

    inner class ItemViewHolder(itemView: View):ViewHolder(itemView){
        fun bindItems(item: String){
            val message = itemView.findViewById<TextView>(R.id.rv_item_tv)
            message.text = item
        }
    }

    inner class LoadingViewHolder(itemView: View):ViewHolder(itemView){
        val progressBar = itemView.findViewById<ProgressBar>(R.id.rv_loading_pb)!!
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] != null) {
            ITEM
        }else{
            LOADING
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if(viewType == ITEM){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
            ItemViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_loading, parent, false)
            LoadingViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(holder is ItemViewHolder){
            holder.bindItems(items[position]!!)
        }else{

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}