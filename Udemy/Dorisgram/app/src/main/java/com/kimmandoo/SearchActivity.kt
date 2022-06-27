package com.kimmandoo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kimmandoo.databinding.ActivityCommentBinding
import com.kimmandoo.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var keywordList: ArrayList<String>? = getKeywords("keywords")
        binding.searchRvKeyword.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.searchRvKeyword.adapter = keywordList?.let{SearchAdapter(this, it)}

        binding.searchEtKeyword.setOnKeyListener{ v, keyCode, event ->
            if(event.action == KeyEvent.ACTION_DOWN && keyCode == KEYCODE_ENTER){
                keywordList!!.add(binding.searchEtKeyword.text.toString())
                saveKeywords("keywords", keywordList)
                binding.searchRvKeyword.adapter!!.notifyDataSetChanged()//변경된 어댑터 갱신하기
                binding.searchEtKeyword.text = null
            }
            true
        }

        binding.searchIvBack.setOnClickListener {
            onBackPressed()
        }

    }


    private fun getKeywords(key: String): ArrayList<String>{
        val prefs = getSharedPreferences("Dorisgram", Context.MODE_PRIVATE)
        val json = prefs.getString(key, "[]")
        val gson = Gson()
            //저장되어있는 키워드를 받아서 배열의 형태로 리턴시켜주게 됨
        return gson.fromJson(
            json,
            object : TypeToken<ArrayList<String?>>() {}.type
        )
    }

    private fun saveKeywords(key:String , values: ArrayList<String>){
        val gson = Gson()
        val json = gson.toJson(values)
        val prefs = getSharedPreferences("Dorisgram", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(key, json)
        editor.apply()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}