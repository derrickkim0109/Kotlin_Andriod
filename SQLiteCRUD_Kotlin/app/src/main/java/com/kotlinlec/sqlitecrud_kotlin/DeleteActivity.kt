package com.kotlinlec.sqlitecrud_kotlin

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class DeleteActivity : AppCompatActivity() {

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
        Log.v(TAG, "Start")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
        studentInfo = StudentInfo(this@DeleteActivity)
        val intent = intent
        scode = intent.getStringExtra("code")
        sname = intent.getStringExtra("name")
        sdept = intent.getStringExtra("dept")
        sphone = intent.getStringExtra("phone")
        Ecode = findViewById(R.id.delete_code)
        Ename = findViewById(R.id.delete_name)
        Edept = findViewById(R.id.delete_dept)
        Ephone = findViewById(R.id.delete_phone)
        Ecode?.setText(scode)
        Ename?.setText(sname)
        Edept?.setText(sdept)
        Ephone?.setText(sphone)
        findViewById<View>(R.id.delete_btn).setOnClickListener(onClickListener)
    }

    private var onClickListener: View.OnClickListener =
        object : View.OnClickListener {
            var DB: SQLiteDatabase? = null
            override fun onClick(v: View) {
                scode = Ecode!!.text.toString()
                try {
                    DB = studentInfo!!.getWritableDatabase()
                    val query =
                        "DELETE FROM student WHERE id = " + scode!!.toInt() + ";"
                    Log.v(TAG, query)
                    DB!!.execSQL(query)
                    studentInfo!!.close()
                } catch (e: Exception) {
                    e.printStackTrace()
                    Log.v(TAG, e.toString())
                }
                Toast.makeText(this@DeleteActivity, sname + "님이 삭제 되었습니다.", Toast.LENGTH_SHORT)
                    .show()

                // 화면 이동
                val intent = Intent(this@DeleteActivity, SelectAllActivity::class.java)
                startActivity(intent)
            }
        }

    companion object {
        const val TAG = "DeleteActivity"
    }
}

