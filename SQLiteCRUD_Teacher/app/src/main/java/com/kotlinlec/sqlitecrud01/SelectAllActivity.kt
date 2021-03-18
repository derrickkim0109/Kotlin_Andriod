package com.kotlinlec.sqlitecrud01

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class SelectAllActivity : AppCompatActivity(){

    private var members: ArrayList<Student>? = ArrayList()
    private var adapter: StudentAdapter? = null
    private var studentInfo: StudentInfo? = null
    private var lvStudent: ListView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_all)

        studentInfo = StudentInfo(this)

//        connectGetData();
    }


    private fun connectGetData() {

        var db: SQLiteDatabase? = null
        //var members = ArrayList<Student>()

        try {

            members!!.clear()
            db = studentInfo!!.readableDatabase
            val query = "SELECT id, name, dept, phone FROM student;"
            val cursor = db!!.rawQuery(query, null)
            while (cursor.moveToNext()) {
                val id = cursor.getString(0)
                val name = cursor.getString(1)
                val dept = cursor.getString(2)
                val phone = cursor.getString(3)
                val member = Student(id, name, dept, phone)
                Log.v(TAG, "name :$name")
                members!!.add(member)
            }
            cursor.close()
            studentInfo!!.close()
            Toast.makeText(this, "Select OK!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Select Error", Toast.LENGTH_SHORT).show()
        }

        try {
            lvStudent = findViewById(R.id.lv_student)
            adapter = StudentAdapter(this@SelectAllActivity, R.layout.student_layout, members)
            //Log.v(TAG, "-> name: $members")
            lvStudent!!.adapter = adapter
            lvStudent!!.onItemClickListener = onItemClickListener
            lvStudent!!.onItemLongClickListener = onItemLongClickListener   // 삭제
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onResume() {
        super.onResume()
        connectGetData()
    }


    private var onItemClickListener: AdapterView.OnItemClickListener = object : AdapterView.OnItemClickListener {
        var intent: Intent? = null

        override fun onItemClick(parent: AdapterView<*>?, view: View, position: Int,id: Long) {
            Log.v(TAG,"Update Start $position")
            Log.v(TAG,"Update Start2 ${members!![0].name}")

            intent = Intent(this@SelectAllActivity, UpdateActivity::class.java)
            intent!!.putExtra("code", members!![position].code)
            intent!!.putExtra("name", members!![position].name)
            intent!!.putExtra("dept", members!![position].dept)
            intent!!.putExtra("phone", members!![position].phone)
            Log.v(TAG, "update : ${members!![position].name}")

            startActivity(intent)
        }
    }

    private var onItemLongClickListener: AdapterView.OnItemLongClickListener = object : AdapterView.OnItemLongClickListener {
        var intent: Intent? = null

        override fun onItemLongClick(parent: AdapterView<*>?, view: View, position: Int, id: Long) : Boolean {
            intent = Intent(this@SelectAllActivity, DeleteActivity::class.java)
            intent!!.putExtra("code", members!![position].code)
            intent!!.putExtra("name", members!![position].name)
            intent!!.putExtra("dept", members!![position].dept)
            intent!!.putExtra("phone", members!![position].phone)

            startActivity(intent)
            return false
        }
    }



    companion object {
        const val TAG = "Kotlin"
    }

}