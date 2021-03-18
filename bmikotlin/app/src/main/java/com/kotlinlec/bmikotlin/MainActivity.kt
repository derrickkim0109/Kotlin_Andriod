package com.kotlinlec.bmikotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn : Button= findViewById(R.id.btn)
        btn.setOnClickListener {
            val edit3 : EditText = findViewById(R.id.result)
            val str : String = "BMI 계산 결과는 " + calcBmi() + "으로 " + resultBmi() + "입니다."
            edit3.setText(str)
        }
    }

    private fun calcBmi(): String {
        val edit1 : EditText = findViewById(R.id.height)
        val edit2 : EditText = findViewById(R.id.weight)
        val heightCm : Double= edit1.text.toString().toDouble()
        val weight : Double = edit2.text.toString().toDouble()
        val height : Double = heightCm * 0.01
        val calc : Double = weight / (height * height)
        return String.format("%.2f", calc)
    }

    private fun resultBmi(): String {
        val bmi : Double = calcBmi().toDouble()
        val bmiResult: String
        bmiResult = if (bmi <= 15) {
            "심한 저체중"
        } else if (bmi > 15 && bmi <= 18.5) {
            "약간 저체중"
        } else if (bmi > 18.5 && bmi <= 25) {
            "표준"
        } else if (bmi > 25 && bmi <= 30) {
            "과체중"
        } else {
            "심한 과체중"
        }
        return bmiResult
    }
}