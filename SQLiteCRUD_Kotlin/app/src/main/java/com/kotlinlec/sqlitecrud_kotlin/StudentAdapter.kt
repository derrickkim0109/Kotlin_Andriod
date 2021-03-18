package com.kotlinlec.sqlitecrud_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.*


class StudentAdapter(
    mContext: Context,
    layout: Int,
    data: ArrayList<Student>?
) :
    BaseAdapter() {
    private var mContext: Context? = null
    private var layout = 0
    private var data: ArrayList<Student>? = null
    private var inflater: LayoutInflater? = null
    override fun getCount(): Int {
        return data!!.size
    }

    override fun getItem(position: Int): Any {
        return data!![position].code
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = inflater!!.inflate(layout, parent, false)
        }
        val tv_code = convertView.findViewById<TextView>(R.id.tv_code)
        val tv_name = convertView.findViewById<TextView>(R.id.tv_name)
        val tv_dept = convertView.findViewById<TextView>(R.id.tv_dept)
        val tv_phone = convertView.findViewById<TextView>(R.id.tv_phone)
        tv_code.text = "학번 : " + data!![position].code
        tv_name.text = "성명 : " + data!![position].name
        tv_dept.text = "전공과 : " + data!![position].dept
        tv_phone.text = "전화번호: " + data!![position].phone
        if (position % 2 == 1) {
            convertView.setBackgroundColor(0x50000000)
        } else {
            convertView.setBackgroundColor(0x50dddddd)
        }
        return convertView
    }

    init {
        this.mContext = mContext
        this.layout = layout
        this.data = data
        inflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
} // -----

