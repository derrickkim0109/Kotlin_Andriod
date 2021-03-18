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


class UpdateActivity : AppCompatActivity() {

    var scode: String? = null
    var sname: String? = null
    var sdept: String? = null
    var sphone: String? = null
    var Ecode: EditText? = null
    var Ename: EditText? = null
    var Edept: EditText? = null
    var Ephone: EditText? = null
    var studentInfo: StudentInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        studentInfo = StudentInfo(this@UpdateActivity)
        val intent = intent
        scode = intent.getStringExtra("code")
        sname = intent.getStringExtra("name")
        sdept = intent.getStringExtra("dept")
        sphone = intent.getStringExtra("phone")
        Ecode = findViewById(R.id.update_code)
        Ename = findViewById(R.id.update_name)
        Edept = findViewById(R.id.update_dept)
        Ephone = findViewById(R.id.update_phone)
        Ecode?.setText(scode)
        Ename?.setText(sname)
        Edept?.setText(sdept)
        Ephone?.setText(sphone)
        Ename?.setFilters(arrayOf<InputFilter>(LengthFilter(10)))
        Edept?.setFilters(arrayOf<InputFilter>(LengthFilter(12)))
        Ephone?.setFilters(arrayOf<InputFilter>(LengthFilter(12)))
        findViewById<View>(R.id.update_btn).setOnClickListener(onClickListener)
    }

    var onClickListener: View.OnClickListener =
        object : View.OnClickListener {
            var DB: SQLiteDatabase? = null
            override fun onClick(v: View) {
                scode = Ecode!!.text.toString()
                sname = Ename!!.text.toString()
                sdept = Edept!!.text.toString()
                sphone = Ephone!!.text.toString()
                try {
                    DB = studentInfo!!.writableDatabase
                    val query =
                        "UPDATE student SET name = '" + sname + "', dept = '" + sdept + "', phone = '" + sphone + "' WHERE id = " + scode!!.toInt() + ";"
                    Log.v(TAG, query)
                    DB!!.execSQL(query)
                    studentInfo!!.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                    Log.v(TAG, e.toString())
                }
                Toast.makeText(this@UpdateActivity, sname + "님이 수정 되었습니다.", Toast.LENGTH_SHORT)
                    .show()

                // 화면 이동
                val intent = Intent(this@UpdateActivity, SelectAllActivity::class.java)
                startActivity(intent)
            }
        }

    companion object {
        const val TAG = "UpdateActivity"
    }
}
