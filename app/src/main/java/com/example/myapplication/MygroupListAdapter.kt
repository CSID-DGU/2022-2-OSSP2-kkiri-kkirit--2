package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class MygroupListAdapter(private val items:MutableList<MygroupListItem>):BaseAdapter() {
    override fun getCount(): Int=items.size

    override fun getItem(position: Int): MygroupListItem=items[position]

    override fun getItemId(position: Int): Long=position.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var convertView=view

        if(convertView==null)
            convertView=LayoutInflater.from(parent?.context).inflate(R.layout.custom_list_item,parent,false)

        val item:MygroupListItem=items[position]
        convertView!!.image_title.setImageDrawable(item.icon)
        convertView.
    }
}