package com.kotlinlec.sqlitecrud01

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class DeleteActivity : AppCompatActivity(){

    var scode: String? = null
    var sname: String? = null
    var sdept: String? = null
    var sphone: String? = null

    var Ecode: EditText? = null
    var Ename: EditText? = null
    var Edept: EditText? = null
    var Ephone: EditText? = null
    var btnDelete: Button? = null

    var studentInfo: StudentInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        studentInfo = StudentInfo(this)

        val intent = intent
        scode = intent.getStringExtra("code")
        sname = intent.getStringExtra("name")
        sdept = intent.getStringExtra("dept")
        sphone = intent.getStringExtra("phone")

        Ecode = findViewById(R.id.delete_code)
        Ename = findViewById(R.id.delete_name)
        Edept = findViewById(R.id.delete_dept)
        Ephone = findViewById(R.id.delete_phone)
        btnDelete = findViewById(R.id.delete_btn)

        Ecode!!.setText(scode)
        Ename!!.setText(sname)
        Edept!!.setText(sdept)
        Ephone!!.setText(sphone)
        btnDelete!!.setOnClickListener(onClickListener)

    }

    var onClickListener = View.OnClickListener {
        var db: SQLiteDatabase? = null

        scode = Ecode!!.text.toString()

        try {
            db = studentInfo!!.writableDatabase
            val query = "DELETE FROM student WHERE id = '$scode';"
            db!!.execSQL(query)
            studentInfo!!.close()
            Toast.makeText(this, "학번 $scode 님의 정보가 삭제 되었습니다.", Toast.LENGTH_LONG).show()
        }catch (e: Exception){
            print(e.printStackTrace())
            Toast.makeText(this, "delete Error", Toast.LENGTH_LONG).show()
        }

        finish()
    }


}