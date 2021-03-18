package com.kotlinlec.sqlitecrud01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var btnInsert: Button? = null
    var btnSelectA: Button? = null
    var btnUpdate: Button? = null
    var btnDelete: Button? = null

    var studentInfo: StudentInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentInfo = StudentInfo(this)
        btnInsert = findViewById(R.id.btn_insert)
        btnSelectA = findViewById(R.id.btn_selectA)
        btnUpdate = findViewById(R.id.btn_update)
        btnDelete = findViewById(R.id.btn_delete)

        addListener()
    }

    private fun addListener(){
        btnInsert?.setOnClickListener(onClickListener)
        btnSelectA?.setOnClickListener(onClickListener)
        btnUpdate?.setOnClickListener(onClickListener)
        btnDelete?.setOnClickListener(onClickListener)
    }

    private var onClickListener = View.OnClickListener { v ->
        var intent: Intent? = null
        when(v.id){
            R.id.btn_insert -> {
                intent = Intent(this, InsertActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_update -> {
                Toast.makeText(this, "검색 후 선택을 짧게 하시면 수정화면으로 이동 합니다.", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_delete -> {
                Toast.makeText(this, "검색 후 선택을 길게 하시면 삭제화면으로 이동 합니다.", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_selectA -> {
                intent = Intent(this, SelectAllActivity::class.java)
                startActivity(intent)
            }

        }
    }


} // ----
