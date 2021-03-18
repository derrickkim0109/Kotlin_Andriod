package com.kotlinlec.sqlitecrud01

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class UpdateActivity  : AppCompatActivity(){

    var scode: String? = null
    var sname: String? = null
    var sdept: String? = null
    var sphone: String? = null

    var Ecode: EditText? = null
    var Ename: EditText? = null
    var Edept: EditText? = null
    var Ephone: EditText? = null
    var btnUpdate: Button? = null

    var studentInfo: StudentInfo? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        studentInfo = StudentInfo(this)

        val intent = intent
        scode = intent.getStringExtra("code")
        sname = intent.getStringExtra("name")
        sdept = intent.getStringExtra("dept")
        sphone = intent.getStringExtra("phone")

        Ecode = findViewById(R.id.update_code)
        Ename = findViewById(R.id.update_name)
        Edept = findViewById(R.id.update_dept)
        Ephone = findViewById(R.id.update_phone)
        btnUpdate = findViewById(R.id.update_btn)

        Ecode!!.setText(scode)
        Ename!!.setText(sname)
        Edept!!.setText(sdept)
        Ephone!!.setText(sphone)
        btnUpdate!!.setOnClickListener(onClickListener)

    }

    var onClickListener = View.OnClickListener {
        var db: SQLiteDatabase? = null

        scode = Ecode!!.text.toString()
        sname = Ename!!.text.toString()
        sdept = Edept!!.text.toString()
        sphone = Ephone!!.text.toString()

        try {
            db = studentInfo!!.writableDatabase
            val query = "UPDATE student SET name = '${sname}', dept = '$sdept', phone = '$sphone' WHERE id = '$scode';"
            db!!.execSQL(query)
            studentInfo!!.close()
            Toast.makeText(this, "학번 $scode 님의 정보가 수정 되었습니다.", Toast.LENGTH_LONG).show()
        }catch (e: Exception){
            print(e.printStackTrace())
            Toast.makeText(this, "update Error", Toast.LENGTH_LONG).show()
        }

        finish()
    }



}