package com.calculator.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextNum1;
    EditText editTextNum2;
    TextView textViewResult;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
        textViewResult = findViewById(R.id.textViewResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnClear = findViewById(R.id.btnClear);

        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnClear) {
            editTextNum1.setText("");
            editTextNum2.setText("");
            textViewResult.setText("");
        }else{
            try {
                double num1 = Double.parseDouble(editTextNum1.getText().toString());
                double num2 = Double.parseDouble(editTextNum2.getText().toString());
                if (v.getId() == R.id.btnAdd) {
                    textViewResult.setText(add(num1, num2) + "");
                } else if (v.getId() == R.id.btnSubtract) {
                    textViewResult.setText(subtract(num1, num2) + "");
                } else if (v.getId() == R.id.btnMultiply) {
                    textViewResult.setText(multiply(num1, num2) + "");
                } else if (v.getId() == R.id.btnDivide) {
                    double result = divide(num1, num2);
                    result = (Double.isNaN(result)) ? 0 : result;
                    textViewResult.setText(result + "");
                }
            }catch(Exception e) {
                Toast.makeText(this, "Check the value of number 1 and number 2", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        return num1 / num2;
    }
}