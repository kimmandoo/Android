package com.kimmandoo.bitbox

import android.content.res.AssetManager
import android.util.Log
import java.lang.Exception

private const val SOUNDS_FOLDER = "sample_sounds"
private const val TAG = "BeatBox"
class BeatBox(private val assets: AssetManager) {
    fun loadSounds(): List<String>{
        try{
            val soundNames = assets.list(SOUNDS_FOLDER)!!
            Log.d(TAG,"Found ${soundNames.size} sounds")
            return soundNames.asList()
        }catch (e: Exception){
            Log.d(TAG,"Could not list assets", e)
            return emptyList()
        }
    }
}