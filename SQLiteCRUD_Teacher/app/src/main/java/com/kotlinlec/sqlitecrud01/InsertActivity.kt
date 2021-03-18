package com.kotlinlec.sqlitecrud01

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class InsertActivity : AppCompatActivity() {

    var Ename: EditText? = null
    var Edept: EditText? = null
    var Ephone: EditText? = null
    var btnInsert: Button? = null

    var sname: String? = null
    var sdept: String? = null
    var sphone: String? = null

    var studentInfo: StudentInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        studentInfo = StudentInfo(this)

        Ename = findViewById(R.id.insert_name)
        Edept = findViewById(R.id.insert_dept)
        Ephone = findViewById(R.id.insert_phone)
        btnInsert = findViewById(R.id.insert_btn)

        // 입력시 자릿수 제한
        Ename!!.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(10))
        Edept!!.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(12))
        Ephone!!.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(12))
        btnInsert!!.setOnClickListener(onClickListener)
    }

    private var onClickListener = View.OnClickListener {
        var db: SQLiteDatabase? = null

        sname = Ename!!.text.toString().trim()
        sdept = Edept!!.text.toString().trim()
        sphone = Ephone!!.text.toString().trim()

        try {
            db = studentInfo!!.writableDatabase
            val query = "INSERT INTO student(name, dept, phone) VALUES ('$sname', '$sdept', '$sphone');"
            db!!.execSQL(query)
            studentInfo!!.close()
            Toast.makeText(this, "$sname 님의 정보가 입력되었습니다.", Toast.LENGTH_LONG).show()
        }catch (e: Exception){
            print(e.printStackTrace())
            Toast.makeText(this, "Insert Error", Toast.LENGTH_LONG).show()
        }
        finish()
    }
} // ----