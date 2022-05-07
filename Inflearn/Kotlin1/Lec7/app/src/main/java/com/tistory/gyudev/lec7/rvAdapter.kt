package com.tistory.gyudev.lec7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class rvAdapter(val context: Context, val List: MutableList<DataModel>):RecyclerView.Adapter<rvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(v)
    }


    interface ItemClick{
        fun onClick(view :View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: rvAdapter.ViewHolder, position: Int) {
//        holder.bindItems(List[position])
        if(itemClick != null){
            holder?.itemView.setOnClickListener{v->
                itemClick!!.onClick(v, position)
            }
        }
        holder.bindItems(List[position])
    }

    override fun getItemCount(): Int {
        return List.size
    }
    inner class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        fun bindItems(item: DataModel){
            val rvImage = itemView.findViewById<ImageView>(R.id.rvImage)
            val rvText = itemView.findViewById<TextView>(R.id.rvText)

            rvText.text = item.titleText
            //Glide를 이용해 이미지 주소로 이미지 가져오기
            Glide.with(context)
                .load(item.titleImageUrl)
                .into(rvImage)
        }
    }
}