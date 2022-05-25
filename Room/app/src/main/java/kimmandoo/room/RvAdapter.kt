package kimmandoo.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kimmandoo.room.databinding.RvItemBinding
import java.text.SimpleDateFormat

class RvAdapter(val memoList : List<RoomMemo>): RecyclerView.Adapter<RvAdapter.Holder>() {

    class Holder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun setItem(memo: RoomMemo){
            with(binding){
                textNum.text = memo.no.toString()
                textDetail.text = memo.content.toString()

                //Long형 값이 날짜로 변환됨
                val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd hh:mm")
                textDate.text = simpleDateFormat.format(memo.datetime)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setItem(memoList.get(position))
    }

    override fun getItemCount() = memoList.size

}