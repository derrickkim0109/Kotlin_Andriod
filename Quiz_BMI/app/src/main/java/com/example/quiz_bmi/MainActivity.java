package com.example.quiz_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends Activity {
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);

        initImage();

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton Rbtn1 = findViewById(R.id.chk1);
                RadioButton Rbtn2 = findViewById(R.id.chk2);
                EditText edit1 = findViewById(R.id.height);
                EditText edit2 = findViewById(R.id.weight);

                EditText BMI = findViewById(R.id.BMI);
                double height = Double.parseDouble(edit1.getText().toString());
                double weight = Double.parseDouble(edit2.getText().toString());
                double height2 = height / 100;
                double result = weight / (height2 * height2);

                String bmi = String.format("%.2f", result);
                BMI.setText(bmi);
                initImage();
                img5.setVisibility(v.INVISIBLE);

                if (result > 30.0) {
                    img4.setVisibility(v.VISIBLE);
                } else if (result >= 25 && result < 30) {
                    img3.setVisibility(v.VISIBLE);
                } else if (result >= 20.0 && result < 24) {
                    img2.setVisibility(v.VISIBLE);
                } else {
                    img1.setVisibility(v.VISIBLE);
                }

            }
        });
    }

    private void initImage(){
        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);
        img3.setVisibility(View.INVISIBLE);
        img4.setVisibility(View.INVISIBLE);
        img5.setVisibility(View.VISIBLE);

    }
}