import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kimmandoo.infinitescroll.databinding.ItemLoadingBinding
import com.kimmandoo.infinitescroll.databinding.ItemRowBinding


class MainRvAdapter(val items: MutableList<String>): RecyclerView.Adapter<MainRvAdapter.ViewHolder>(){

    inner class ViewHolder(private val binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root){
        fun setItem(){
            with(binding){

            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return items.size
    }

}
