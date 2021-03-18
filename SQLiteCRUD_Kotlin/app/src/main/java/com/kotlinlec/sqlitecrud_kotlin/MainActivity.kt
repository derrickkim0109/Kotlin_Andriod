package com.kotlinlec.sqlitecrud_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var insertBtn: Button? = null
    private var updateBtn: Button? = null
    private var deleteBtn: Button? = null
    private var selectAllBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addListener()
    }

    private fun addListener() {
        insertBtn = findViewById(R.id.btn_insert)
        updateBtn = findViewById(R.id.btn_update)
        deleteBtn = findViewById(R.id.btn_delete)
        selectAllBtn = findViewById(R.id.btn_selectA)


        insertBtn?.setOnClickListener(onClickListener)
        updateBtn?.setOnClickListener(onClickListener)
        deleteBtn?.setOnClickListener(onClickListener)
        selectAllBtn?.setOnClickListener(onClickListener)
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


} // ------
