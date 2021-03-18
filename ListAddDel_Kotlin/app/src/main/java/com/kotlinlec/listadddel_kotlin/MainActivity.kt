package com.kotlinlec.listadddel_kotlin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    var Items: ArrayList<String>? = null
    var Adapter: ArrayAdapter<String>? = null
    var list: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Items = ArrayList()
        Items!!.add("First")
        Items!!.add("Second")
        Items!!.add("Third")

        Adapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, Items!!)
        list = findViewById(R.id.list)

        list!!.setAdapter(Adapter)
        list!!.setChoiceMode(ListView.CHOICE_MODE_SINGLE)
        list!!.setOnItemClickListener(mItemClickListener)
        findViewById<View>(R.id.add).setOnClickListener(mClickListener)
        findViewById<View>(R.id.delete).setOnClickListener(mClickListener)
    }

    var mClickListener = View.OnClickListener { v ->
        val ed = findViewById<EditText>(R.id.newitem)
        when (v.id) {
            R.id.add -> {
                val text = ed.text.toString()
                if (text.length != 0) {
                    Items!!.add(text)
                    ed.setText("")
                    Adapter!!.notifyDataSetChanged()
                }
            }
            R.id.delete -> {
                val id: Int
                id = list!!.checkedItemPosition
                if (id != ListView.INVALID_POSITION) {
                    Items!!.removeAt(id)
                    list!!.clearChoices()
                    Adapter!!.notifyDataSetChanged()
                }
            }
        }
    }
    var mItemClickListener = OnItemClickListener { parent, view, position, id ->
        val mes: String
        mes = "Select Item = " + Items!![position]
        Toast.makeText(this@MainActivity, mes, Toast.LENGTH_SHORT).show()
    }
} // -----
