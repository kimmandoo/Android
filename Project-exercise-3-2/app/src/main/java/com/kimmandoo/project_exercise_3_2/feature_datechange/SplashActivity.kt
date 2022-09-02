package com.kimmandoo.project_exercise_3_2.feature_datechange

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Room
import com.kimmandoo.project_exercise_3_2.MainActivity
import com.kimmandoo.project_exercise_3_2.databinding.ActivitySplashBinding
import com.kimmandoo.project_exercise_3_2.databinding.FragmentRoomExpBinding
import com.kimmandoo.project_exercise_3_2.feature_room_exp.RoomExpFragment
import com.kimmandoo.project_exercise_3_2.feature_room_exp.RoomHelper
import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class SplashActivity : AppCompatActivity() {
    lateinit var helper: RoomHelper

    private lateinit var mPreferences: SharedPreferences

    companion object {
        const val sharedPrefFile = "datetime"
    }

    val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    //Date change detection
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = Intent(this, MainActivity::class.java)

        CoroutineScope(Dispatchers.Main).launch {
            val job = CoroutineScope(Dispatchers.IO).async {
                val previousDate = getDate()
//        val previousDate = "2022-09-01"
                val current = LocalDateTime.now()
                val formatter = DateTimeFormatter.ISO_DATE
                val formatted = current.format(formatter)
                if (previousDate != formatted) {
                    //날짜가 바뀐 것임.
                    saveDate(formatted)
                    Log.d("CurrentDate", "$formatted 날짜바뀜")
                    //이게 되나
                    RoomExpFragment().expRoomDbBuild()
                    //날짜 바뀌었을 때 해야되는 작업 여기서
                    //앱 데이터를 서버로 넘기기

//            helper = Room.databaseBuilder(this, RoomHelper::class.java, "roomexpdb")
//                .build()

                } else {
                    //이전 날짜가 없다는 의미이므로 지금날짜 저장해줌.
                    if (previousDate.isNullOrEmpty()) {
                        Log.d("CurrentDate", "$formatted 비어있음")
                        saveDate(formatted)
                    }
                    else{Log.d("CurrentDate", "$formatted 날짜가 동일")}
                }
            }
            job.await()
            startActivity(intent)
            finish()
        }
    }

    private fun saveDate(date: String) {
        mPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);
        val preferencesEditor: SharedPreferences.Editor = mPreferences.edit()
        preferencesEditor.putString("date", date)
        Log.d("sharedPref", preferencesEditor.putString("date", date).toString())
        //commit은 sync, apply는 async 적으로 동작함
        preferencesEditor.apply()
    }

    private fun getDate(): String? {
        mPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE);
        Log.d("sharedPref", mPreferences.getString("date","").toString())
        return mPreferences.getString("date", "")
    }

}