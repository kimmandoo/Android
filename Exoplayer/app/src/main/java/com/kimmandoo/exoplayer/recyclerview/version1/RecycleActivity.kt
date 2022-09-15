package com.kimmandoo.exoplayer.recyclerview.version1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ExoPlayer
import com.kimmandoo.exoplayer.R
import com.kimmandoo.exoplayer.databinding.ActivityRecycleBinding

class RecycleActivity : AppCompatActivity() {
    private val binding by lazy { ActivityRecycleBinding.inflate(layoutInflater) }
    private var player: ExoPlayer? = null

    private val TAG = "Recycle"
//    var stringItem = "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"

    var stringItem = "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4"
    var stringItem2 = "https://thumbs.gfycat.com/FoolhardyMiserlyAsiantrumpetfish-mobile.mp4"

    val items = mutableListOf<String>(
        stringItem,
        stringItem2,
        stringItem,
        stringItem2,
        stringItem,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val rvAdapter = RvAdapter(this, items)

        binding.rv.adapter = rvAdapter
        binding.rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rv.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                Log.d(TAG, "scrolled")
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    //player를 메모리에서 떼주는 역할
    private fun releasePlayer() {
        player?.run {
//            playbackPosition = this.currentPosition
//            currentWindow = this.currentMediaItemIndex
//            playWhenReady = this.playWhenReady
            release()
        }
        player = null
    }
}