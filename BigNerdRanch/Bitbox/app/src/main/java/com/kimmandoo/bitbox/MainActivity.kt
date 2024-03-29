package com.kimmandoo.bitbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kimmandoo.bitbox.databinding.ActivityMainBinding
import com.kimmandoo.bitbox.databinding.ListItemSoundBinding

class MainActivity : AppCompatActivity() {
//    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var beatBox : BeatBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beatBox = BeatBox(assets)
        beatBox.loadSounds()

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.rv.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = SoundAdapter()
        }

    }

    inner class SoundHolder(private val binding: ListItemSoundBinding) : RecyclerView.ViewHolder(binding.root){

    }

    inner class SoundAdapter() : RecyclerView.Adapter<SoundHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            val binding = DataBindingUtil.inflate<ListItemSoundBinding>(layoutInflater, R.layout.list_item_sound, parent, false)
            return SoundHolder(binding)
        }

        override fun onBindViewHolder(holder: SoundHolder, position: Int) {

        }

        override fun getItemCount(): Int {
            return 0
        }

    }
}