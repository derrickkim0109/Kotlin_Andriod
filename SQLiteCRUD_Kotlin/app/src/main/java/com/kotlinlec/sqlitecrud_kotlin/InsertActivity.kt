package com.kotlinlec.sqlitecrud_kotlin

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class InsertActivity : AppCompatActivity() {
    var sname: String? = null
    var sdept: String? = null
    var sphone: String? = null
    var Ename: EditText? = null
    var Edept: EditText? = null
    var Ephone: EditText? = null
    var studentInfo: StudentInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        studentInfo = StudentInfo(this@InsertActivity)
        Ename = findViewById(R.id.insert_name)
        Edept = findViewById(R.id.insert_dept)
        Ephone = findViewById(R.id.insert_phone)
        Ename?.setFilters(arrayOf<InputFilter>(LengthFilter(10))) // 입력 자릿수 제한
        Edept?.setFilters(arrayOf<InputFilter>(LengthFilter(12)))
        Ephone?.setFilters(arrayOf<InputFilter>(LengthFilter(12)))
        findViewById<View>(R.id.insert_btn).setOnClickListener(onClickListener)
    }

    private var onClickListener: View.OnClickListener =
        object : View.OnClickListener {
            var DB: SQLiteDatabase? = null
            override fun onClick(view: View) {
                sname = Ename!!.text.toString()
                sdept = Edept!!.text.toString()
                sphone = Ephone!!.text.toString()
                try {
                    DB = studentInfo!!.getWritableDatabase()
                    val query =
                        "INSERT INTO student(name, dept, phone) VALUES ('$sname', '$sdept', '$sphone');"
                    DB!!.execSQL(query)
                    Log.v(TAG, query)
                    studentInfo!!.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                Toast.makeText(this@InsertActivity, sname + "님이 입력 되었습니다.", Toast.LENGTH_SHORT)
                    .show()

                // 화면 이동
                val intent = Intent(this@InsertActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }

    companion object {
        const val TAG = "InsertActivity"
    }
} // ----- DB 보기 : View > Tool Windows > Device File Explorer ... data > data > package name


