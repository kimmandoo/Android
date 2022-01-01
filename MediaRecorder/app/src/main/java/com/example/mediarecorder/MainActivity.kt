package com.example.mediarecorder

import android.R.attr
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.R.attr.path
import android.R.attr.start
import android.content.Context
import android.util.Log
import java.io.DataOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filename = "myfile"
        val text = "this is test"
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)



        val btnRecord = findViewById<Button>(R.id.btnRecord)
        val btnRecordStop = findViewById<Button>(R.id.btnRecordStop)

        val filePath = filesDir.toString()
//        val fileName = "${externalCacheDir?.absolutePath}/test.3gp"
        val fileName = "${filesDir.absolutePath}/recordtest.3gp"

        var recorder: MediaRecorder? = null

          // Recording is now started
//        recorder.reset()  // You can reuse the object by going back to setAudioSource() step
//        recorder.release() // Now the object cannot be reused

        btnRecord.setOnClickListener {
            fileOutputStream.write(text.toByteArray())
            fileOutputStream.close()

            recorder =  MediaRecorder().apply {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
                setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
                setOutputFile(fileName)
                try {
                    prepare()
                } catch (e: IOException) {
                    Log.e("Err", "prepare() failed")
                }
                start()
            }
        }
        btnRecordStop.setOnClickListener {

            recorder?.apply{
                stop()
                release()
            }
            Log.d("Recording",""+filePath)
            recorder = null
        }
    }
}