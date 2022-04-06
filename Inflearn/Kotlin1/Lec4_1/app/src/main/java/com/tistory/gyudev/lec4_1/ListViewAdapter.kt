package com.tistory.gyudev.lec4_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast

class ListViewAdapter(val List : MutableList<String>): BaseAdapter() {
    override fun getCount(): Int {
        //TODO("Not yet implemented")
        return List.size
        //list 전체 크기
    }

    override fun getItem(p0: Int): Any {
        //TODO("Not yet implemented")
        return List[p0]
        //각각에 해당하는 아이템
    }

    override fun getItemId(p0: Int): Long {
        //TODO("Not yet implemented")
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //TODO("Not yet implemented")

        var converView = p1
        if(converView == null){
            //비어있으면 뷰를 가져와준다.
            converView = LayoutInflater.from(p2?.context).inflate(R.layout.listview,p2,false)
        }
        val message = converView!!.findViewById<TextView>(R.id.listViewText)
        message.text = List[p0]
        //ListView 각각의 item에 대한 건 여기서 처리해야됨.
        message.setOnClickListener {
            Toast.makeText(converView.context, List[p0], Toast.LENGTH_SHORT).show()
        }

        return converView!!
    }
}