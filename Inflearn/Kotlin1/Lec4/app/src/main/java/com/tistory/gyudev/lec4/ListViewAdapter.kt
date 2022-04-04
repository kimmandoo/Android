package com.tistory.gyudev.lec4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val List: MutableList<String>) : BaseAdapter() {
    override fun getCount(): Int {
        //TODO("Not yet implemented")
        return List.size
    }

    override fun getItem(p0: Int): Any {
        //TODO("Not yet implemented")
        return List[p0]
    }

    override fun getItemId(p0: Int): Long {
        //TODO("Not yet implemented")
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //TODO("Not yet implemented")
        var converView = p1

        if(converView == null){
            converView = LayoutInflater.from(p2?.context).inflate(R.layout.listview_item, p2, false)
        }

        val message = converView!!.findViewById<TextView>(R.id.listViewItem)
        message.text = List[p0]

        return converView!!
    }
}