package com.tistory.gyudev.lec7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val items = mutableListOf<DataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add(
            DataModel(
                "https://www.mangoplate.com/restaurants/DemJJ12C1J",
                "https://mp-seoul-image-production-s3.mangoplate.com/1641180_1631759964110836.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "나인스게이트"
            )
        )
        items.add(
            DataModel(
                "https://www.mangoplate.com/restaurants/koJ-1vE9dB",
                "https://mp-seoul-image-production-s3.mangoplate.com/571842_1646909515122128.jpg?fit=around|738:738&crop=738:738;*,*&output-format=jpg&output-quality=80",
                "주옥"
            )
        )
        items.add(
            DataModel(
                "https://www.mangoplate.com/restaurants/DemJJ12C1J",
                "https://mp-seoul-image-production-s3.mangoplate.com/1641180_1631759964110836.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "나인스게이트"
            )
        )
        items.add(
            DataModel(
                "https://www.mangoplate.com/restaurants/DemJJ12C1J",
                "https://mp-seoul-image-production-s3.mangoplate.com/1641180_1631759964110836.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "나인스게이트"
            )
        )
        items.add(
            DataModel(
                "https://www.mangoplate.com/restaurants/DemJJ12C1J",
                "https://mp-seoul-image-production-s3.mangoplate.com/1641180_1631759964110836.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "나인스게이트"
            )
        )
        items.add(
            DataModel(
                "https://www.mangoplate.com/restaurants/DemJJ12C1J",
                "https://mp-seoul-image-production-s3.mangoplate.com/1641180_1631759964110836.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "나인스게이트"
            )
        )
        items.add(
            DataModel(
                "https://www.mangoplate.com/restaurants/DemJJ12C1J",
                "https://mp-seoul-image-production-s3.mangoplate.com/1641180_1631759964110836.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "나인스게이트"
            )
        )
        items.add(
            DataModel(
                "https://www.mangoplate.com/restaurants/koJ-1vE9dB",
                "https://mp-seoul-image-production-s3.mangoplate.com/571842_1646909515122128.jpg?fit=around|738:738&crop=738:738;*,*&output-format=jpg&output-quality=80",
                "주옥"
            )
        )
        items.add(
            DataModel(
                "https://www.mangoplate.com/restaurants/DemJJ12C1J",
                "https://mp-seoul-image-production-s3.mangoplate.com/1641180_1631759964110836.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "나인스게이트"
            )
        )
        items.add(
            DataModel(
                "https://www.mangoplate.com/restaurants/DemJJ12C1J",
                "https://mp-seoul-image-production-s3.mangoplate.com/1641180_1631759964110836.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "나인스게이트"
            )
        )
        items.add(
            DataModel(
                "https://www.mangoplate.com/restaurants/DemJJ12C1J",
                "https://mp-seoul-image-production-s3.mangoplate.com/1641180_1631759964110836.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "나인스게이트"
            )
        )
        items.add(
            DataModel(
                "https://www.mangoplate.com/restaurants/DemJJ12C1J",
                "https://mp-seoul-image-production-s3.mangoplate.com/1641180_1631759964110836.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "나인스게이트"
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv)

        val rvadapter = rvAdapter(baseContext, items)
        recyclerView.adapter = rvadapter

        rvadapter.itemClick = object: rvAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {

                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("image", items[position].titleImageUrl)
                intent.putExtra("title", items[position].titleText)
                startActivity(intent)
            }
        }

        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}