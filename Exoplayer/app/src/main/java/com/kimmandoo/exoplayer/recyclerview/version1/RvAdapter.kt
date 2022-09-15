package com.kimmandoo.exoplayer.recyclerview.version1

import android.content.Context
import android.print.PrintAttributes
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.MediaMetadata
import com.google.android.exoplayer2.analytics.AnalyticsListener
import com.google.android.exoplayer2.decoder.DecoderCounters
import com.google.android.exoplayer2.metadata.Metadata
import com.google.android.exoplayer2.trackselection.MappingTrackSelector
import com.google.android.exoplayer2.util.EventLogger
import com.google.android.exoplayer2.video.VideoSize
import com.kimmandoo.exoplayer.databinding.RvItemBinding

class RvAdapter(val context: Context, val items: MutableList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var player: ExoPlayer? = null
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L
    var pause = false

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        Log.d("Adapter", "view attached")
        if (holder is ItemViewHolder) {
            player?.run {
                pause()
            }
        } else {
        }
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        Log.d("Adapter", "view detached")

        if (holder is ItemViewHolder) {
            player?.run {
                pause()
            }

        } else {
        }
    }

//처음 뷰에 붙으면 일단 일시정지 시켜둠
//    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
//        super.onViewRecycled(holder)
//        Log.d("Adapter","recycled")
//        if (holder is ItemViewHolder) {
//            player?.run {
//                this.seekTo(currentWindow, playbackPosition)
//                play()
//            }
//        }else{}
//    }
//
//    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
//        super.onAttachedToRecyclerView(recyclerView)
//        Log.d("Adapter","recycled on")
//    }
//
//    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
//        super.onDetachedFromRecyclerView(recyclerView)
//        Log.d("Adapter","recycled on")
//    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    inner class ItemViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        lateinit var itemUri: String
        fun setItem(item: String) {
            with(binding) {
//                //item test
//                binding.itemVideoNum.text = item
                itemUri = item
                initializePlayer()
            }
        }

        private fun initializePlayer() {
            player = ExoPlayer.Builder(context)
                .build()
                .also { exoPlayer ->
                    binding.itemVideoView.player = exoPlayer
                    val mediaItem = MediaItem.fromUri(itemUri)
                    exoPlayer.setMediaItem(mediaItem)
                    exoPlayer.playWhenReady = playWhenReady
                    exoPlayer.seekTo(currentWindow, playbackPosition)
                    exoPlayer.prepare()
                }

            player!!.let { it ->
                with(it) {
                    addAnalyticsListener(object :
                        EventLogger(trackSelector as MappingTrackSelector) {

                        override fun onVideoSizeChanged(
                            eventTime: AnalyticsListener.EventTime,
                            videoSize: VideoSize
                        ) {
                            super.onVideoSizeChanged(eventTime, videoSize)
                            Log.d(
                                "TAG_DEBUG", "decoder Name : ${
                                    videoSize.width
                                }x${videoSize.height}"
                            )

                        }
//                        override fun onVideoDecoderInitialized(
//                            eventTime: AnalyticsListener.EventTime,
//                            decoderName: String,
//                            initializationDurationMs: Long,
//                        ) {
//                            super.onVideoDecoderInitialized(
//                                eventTime,
//                                decoderName,
//                                initializationDurationMs,
//                            )
//                            Log.d("TAG_DEBUG", "decoder Name : $decoderName")
//                        }
                    })
                }
            }
//            Log.d("getsize", ": ${player.videoSize}")
        }
    }

    //RecyclerView.ViewHolder, viewType 받아서 지정하는게 정석
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(view)
    }


    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.itemUri = items[position]
            holder.setItem(items[position]!!)
            holder.binding.itemVideoView.setOnClickListener {
                if (!pause) {
                    pause = true
                    holder.binding.itemVideoView.player?.pause()
                } else {
                    holder.binding.itemVideoView.player?.play()
                    pause = false
                }
            }
        } else {

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}