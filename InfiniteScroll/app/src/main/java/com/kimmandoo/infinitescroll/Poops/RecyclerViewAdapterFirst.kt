package com.kimmandoo.infinitescroll.Poops

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimmandoo.infinitescroll.databinding.RvItemBinding
import com.kimmandoo.infinitescroll.databinding.RvLoadingBinding

class RecyclerViewAdapterFirst : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1
    private val items = ArrayList<String>()

    // 아이템뷰에 게시물이 들어가는 경우
    inner class NoticeViewHolder(private val binding: RvItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(text: String){
            binding.rvItemTv.text = text
        }
    }

    // 아이템뷰에 프로그레스바가 들어가는 경우
    inner class LoadingViewHolder(private val binding: RvLoadingBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    // view type setter
    override fun getItemViewType(position: Int): Int {
        // 게시물과 프로그레스바 아이템뷰를 구분할 기준이 필요하다.
        return when (items[position]) {
            " " -> VIEW_TYPE_LOADING
            else -> VIEW_TYPE_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RvItemBinding.inflate(layoutInflater, parent, false)
                NoticeViewHolder(binding)
            }
            else -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RvLoadingBinding.inflate(layoutInflater, parent, false)
                LoadingViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is NoticeViewHolder){
            holder.bind(items[position])
        }else{

        }
    }

    fun setList(text: MutableList<String>) {
        items.addAll(text)
        items.add(" ") // progress bar 넣을 자리
    }

    fun deleteLoading(){
        items.removeAt(items.lastIndex) // 로딩이 완료되면 프로그레스바를 지움
    }

    override fun getItemCount(): Int {
        return items.size
    }
}