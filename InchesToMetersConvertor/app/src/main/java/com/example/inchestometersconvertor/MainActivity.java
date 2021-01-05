package com.example.inchestometersconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText inches;
    Button calculate;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        clickCalculate();
    }

    private void clickCalculate() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i = inches.getText().toString();
                if (i.isEmpty()) {
                    Toast.makeText(MainActivity.this, "U havent given inches", Toast.LENGTH_LONG).show();
                } else {
                    calculateMeter(i);
                }


            }
        });
    }

    private void calculateMeter(String i) {
        double in = Double.parseDouble(i);
        double me = in * 0.0254;
        DecimalFormat fo = new DecimalFormat("0.00");
        String res = fo.format(me);
        result.setText("The inches converted in meters is " + res + " m");

    }

    private void findView() {
        inches = findViewById(R.id.Inches);
        calculate = findViewById(R.id.Calculate_Button);
        result = findViewById(R.id.Result);
    }
}
