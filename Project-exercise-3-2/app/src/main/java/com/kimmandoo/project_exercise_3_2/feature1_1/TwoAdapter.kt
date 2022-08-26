package com.kimmandoo.project_exercise_3_2.feature1_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kimmandoo.project_exercise_3_2.databinding.IngredientItemBinding
import com.kimmandoo.project_exercise_3_2.databinding.ToolItemBinding

class TwoAdapter(val list: MutableList<Tool>): RecyclerView.Adapter<RecyclerView.ViewHolder>(), View.OnClickListener {

    inner class itemViewHolder(val binding: ToolItemBinding): RecyclerView.ViewHolder(binding.root){
        val btnPlus = binding.ingredientItemIvPlus
        val btnMinus = binding.ingredientItemIvMinus

        fun setItem(item: Tool){
            with(binding){
                ingredientItemTv.text = item.name
                if(item.exist.equals("1")){
                    ingredientItemTvNums.text = "있음"
                }else{
                    ingredientItemTvNums.text = "없음"
                }
            }
        }
    }

    interface ItemClick{
        fun onClick(view : View, position: Int)
    }

    var minusClick : ItemClick? = null
    var plusClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ToolItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return itemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is itemViewHolder) {
            if(minusClick != null){
                holder.btnMinus.setOnClickListener{v->
                    minusClick!!.onClick(v, position)
                }
            }
            if(plusClick != null){
                holder.btnPlus.setOnClickListener{v->
                    plusClick!!.onClick(v, position)
                }
            }
            holder.setItem(list[position]!!)

        } else {

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}