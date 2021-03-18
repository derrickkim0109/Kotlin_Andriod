package com.khankong.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edit3 = findViewById(R.id.result);

                String str = "BMI 계산 결과는 " + calcBmi() + "으로 " + resultBmi() + "입니다.";
                edit3.setText(str);


            }
        });

    }


    private String calcBmi() {
        EditText edit1 = findViewById(R.id.height);
        EditText edit2 = findViewById(R.id.weight);

        double heightCm = Double.parseDouble(edit1.getText().toString());
        double weight = Double.parseDouble(edit2.getText().toString());

        double height = heightCm * 0.01;
        double calc = weight / (height * height);
        String bmi = String.format("%.2f", calc);

        return bmi;
    }

    private String resultBmi() {
        double bmi = Double.parseDouble(calcBmi());
        String bmiResult;

        if(bmi <= 15) {
            bmiResult = "심한 저체중";
        } else if(bmi > 15 && bmi <= 18.5) {
            bmiResult = "약간 저체중";
        } else if(bmi > 18.5 && bmi <= 25) {
            bmiResult = "표준";
        } else if(bmi > 25 && bmi <= 30) {
            bmiResult = "과체중";
        } else {
            bmiResult = "심한 과체중";
        }

        return bmiResult;

    }

}