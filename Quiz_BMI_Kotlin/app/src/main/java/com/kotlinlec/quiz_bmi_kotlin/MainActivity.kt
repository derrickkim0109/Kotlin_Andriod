package com.kotlinlec.quiz_bmi_kotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var img1: ImageView? = null
    var img2: ImageView? = null
    var img3: ImageView? = null
    var img4: ImageView? = null
    var img5: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img1 = findViewById(R.id.img1)
        img2 = findViewById(R.id.img2)
        img3 = findViewById(R.id.img3)
        img4 = findViewById(R.id.img4)
        img5 = findViewById(R.id.img5)

        initImage()
        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            val Rbtn1: RadioButton = findViewById(R.id.chk1)
            val Rbtn2: RadioButton = findViewById(R.id.chk2)
            val edit1: EditText = findViewById(R.id.height)
            val edit2: EditText = findViewById(R.id.weight)
            val BMI: EditText = findViewById(R.id.BMI)
            val height: Double  = edit1.text.toString().toDouble()
            val weight: Double  = edit2.text.toString().toDouble()
            val height2: Double = height / 100
            val result: Double = weight / (height2 * height2)
            val bmi: String = String.format("%.2f", result)
            BMI.setText(bmi)
            initImage()
            img5!!.visibility = View.INVISIBLE
            if (result > 30.0) {
                img4!!.visibility = View.VISIBLE
            } else if (result >= 25 && result < 30) {
                img3!!.visibility = View.VISIBLE
            } else if (result >= 20.0 && result < 24) {
                img2!!.visibility = View.VISIBLE
            } else {
                img1!!.visibility = View.VISIBLE
            }
        }
    }
    private fun initImage() {
        img1!!.visibility = View.INVISIBLE
        img2!!.visibility = View.INVISIBLE
        img3!!.visibility = View.INVISIBLE
        img4!!.visibility = View.INVISIBLE
        img5!!.visibility = View.VISIBLE
    }
}