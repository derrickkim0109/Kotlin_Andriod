package com.kotlinlec.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kotlinlec.myapplication.R

class MainActivity : AppCompatActivity() {
    var mtoast: Toast? = null
    var count = 0
    var str: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.shortmsg)
        val button2: Button = findViewById(R.id.longmsg)
        val button3: Button = findViewById(R.id.count1)
        val button4: Button = findViewById(R.id.snackbar)


        button1.setOnClickListener(mClickListener)
        button2.setOnClickListener(mClickListener)
        button3.setOnClickListener(mClickListener)

        // it -> swift에서 _ (underbar)이다.
        button4.setOnClickListener {
            Snackbar.make(it, "Snackbar를 눌렀습니다.", Snackbar.LENGTH_SHORT).show()
        }
    }

    private var mClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.shortmsg -> Toast.makeText(this, "잠시 나타나는 메세지", Toast.LENGTH_SHORT).show()
            R.id.longmsg -> Toast.makeText(this, "조금 길게 나타나는 메세지", Toast.LENGTH_LONG).show()
            R.id.count1 -> {
                str = "현재 카운트 = " + count++
                if (mtoast != null) {
                    mtoast!!.cancel()
                }
                mtoast = Toast.makeText(this@MainActivity, str, Toast.LENGTH_LONG)
                mtoast!!.show()
            }
        }
    }
}