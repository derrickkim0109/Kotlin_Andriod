package com.kotlinlec.sqlitecrud01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class StudentAdapter(mContext: Context, layout: Int, data: ArrayList<Student>?) : BaseAdapter() {
    private var mContext: Context? = null
    private var layout = 0
    private var data: ArrayList<Student>? = null
    private var inflater: LayoutInflater? = null

    init {
        this.mContext = mContext
        this.layout = layout
        this.data = data
        inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return data!!.size
    }

    override fun getItem(position: Int): String? {
        return data!![position].code
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertview = convertView
        if (convertview == null) {
            convertview = inflater!!.inflate(layout, parent, false)
        }
        val tvCode = convertview!!.findViewById<TextView>(R.id.tv_code)
        val tvName = convertview!!.findViewById<TextView>(R.id.tv_name)
        val tvDept = convertview!!.findViewById<TextView>(R.id.tv_dept)
        val tvPhone = convertview!!.findViewById<TextView>(R.id.tv_phone)

        tvCode.text = "학번 : " + data!![position].code
        tvName.text = "이름 : " + data!![position].name
        tvDept.text = "전공 : " + data!![position].dept
        tvPhone.text = "전화 : " + data!![position].phone
        if (position % 2 == 1) {
            convertview!!.setBackgroundColor(0x50000000)
        } else {
            convertview!!.setBackgroundColor(0x50dddddd)
        }
        return convertview

    }


} // -----
