package com.kimmandoo.project_exercise_3_2.feature1

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class OneAdapter(val list: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class itemViewHolder(){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.size
    }
}