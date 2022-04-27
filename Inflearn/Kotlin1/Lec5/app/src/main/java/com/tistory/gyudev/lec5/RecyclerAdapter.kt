package com.tistory.gyudev.lec5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RecyclerAdapter(val items: MutableList<String>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        //xml에 있는 item을 부르는 것
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)

        return ViewHolder(view)
    }
    interface ItemClick{
        fun onClick(view: View, position: Int)
    }
    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        if(itemClick != null) {
            holder.itemView.setOnClickListener{v->
                itemClick?.onClick(v, position)
            }
        }
        holder.bindItems(items[position])//view binding : adapter에 들어온 데이터를 연결된 xml에 보내주는 작업
    }
    override fun getItemCount(): Int {
        //전체 리사이클러뷰의 개수
        return items.size
    }
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(item: String){
            //data mapping
            val rv_text = itemView.findViewById<TextView>(R.id.textView)
            rv_text.text = item
        }
    }
}