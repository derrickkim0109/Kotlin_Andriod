package com.kotlinlec.sqlitecrud_kotlin

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class SelectAllActivity : AppCompatActivity() {
    var students = ArrayList<Student>()
    var adapter: StudentAdapter? = null
    var listView: ListView? = null
    var studentInfo: StudentInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selectall)
        listView = findViewById(R.id.lv_student)
        studentInfo = StudentInfo(this@SelectAllActivity)
    }

    override fun onResume() {
        super.onResume()
        connectGetData()
        Log.v(TAG, "onResume()")
    }

    private fun connectGetData() {
        val DB: SQLiteDatabase
        try {
            students.clear()
            DB = studentInfo!!.getReadableDatabase()
            val query = "SELECT id, name, dept, phone FROM student;"
            val cursor = DB.rawQuery(query, null)
            while (cursor.moveToNext()) {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val dept = cursor.getString(2)
                val phone = cursor.getString(3)
                val student = Student(Integer.toString(id), name, dept, phone)
                students.add(student)
            }
            cursor.close()
            studentInfo!!.close()
            Toast.makeText(this@SelectAllActivity, "Select OK!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this@SelectAllActivity, "Select Error", Toast.LENGTH_SHORT).show()
        }
        try {
            adapter = StudentAdapter(this@SelectAllActivity, R.layout.student_layout, students)
            listView!!.setAdapter(adapter)
            listView!!.onItemClickListener = onItemClickListener
            listView!!.onItemLongClickListener = onItemLongClickListener
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private var onItemClickListener: OnItemClickListener = object : OnItemClickListener {
        var intent: Intent? = null
        override fun onItemClick(
            parent: AdapterView<*>?,
            view: View,
            position: Int,
            id: Long
        ) {
            intent = Intent(this@SelectAllActivity, UpdateActivity::class.java)
            intent!!.putExtra("code", students[position].code)
            intent!!.putExtra("name", students[position].name)
            intent!!.putExtra("dept", students[position].dept)
            intent!!.putExtra("phone", students[position].phone)
            startActivity(intent)
        }
    }
    private var onItemLongClickListener: OnItemLongClickListener = object : OnItemLongClickListener {
        var intent: Intent? = null
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View,
            position: Int,
            id: Long
        ): Boolean {
            intent = Intent(this@SelectAllActivity, DeleteActivity::class.java)
            intent!!.putExtra("code", students[position].code)
            intent!!.putExtra("name", students[position].name)
            intent!!.putExtra("dept", students[position].dept)
            intent!!.putExtra("phone", students[position].phone)
            startActivity(intent)
            return false
        }
    }

    companion object {
        const val TAG = "SelectAllActivity"
    }
} // -----

