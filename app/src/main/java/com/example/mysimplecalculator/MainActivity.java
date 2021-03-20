package com.example.mysimplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Double operand1;
    private Double operand2;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operand1 = null;
        operand2 = null;

        display = findViewById(R.id.textView);

        Button ac = findViewById(R.id.ac);
        Button negativeSwitch = findViewById(R.id.min_plus);
        Button percent = findViewById(R.id.percent);
        Button divide = findViewById(R.id.div);

        Button seven = findViewById(R.id._7);
        Button eight = findViewById(R.id._8);
        Button nine = findViewById(R.id._9);
        Button multiply = findViewById(R.id.mult);

        Button four = findViewById(R.id._4);
        Button five = findViewById(R.id._5);
        Button six = findViewById(R.id._6);
        Button minus = findViewById(R.id.minus);

        Button one = findViewById(R.id._1);
        Button two = findViewById(R.id._2);
        Button three = findViewById(R.id._3);
        Button plus = findViewById(R.id.plus);

        Button zero = findViewById(R.id._0);
        Button comma = findViewById(R.id.comma);
        Button equal = findViewById(R.id.equal);

        ac.setOnClickListener(v -> acOperation());
        seven.setOnClickListener(v -> {
            if(display.getText().length() == 1 && "0".equals(display.getText())) {
                display.setText("");
            }
            display.append("7");
        });
        eight.setOnClickListener(v -> {
            if(display.getText().length() == 1 && "0".equals(display.getText())) {
                display.setText("");
            }
            display.append("8");
        });
        nine.setOnClickListener(v -> {
            if(display.getText().length() == 1 && "0".equals(display.getText())) {
                display.setText("");
            }
            display.append("9");
        });
        four.setOnClickListener(v -> {
            if(display.getText().length() == 1 && "0".equals(display.getText())) {
                display.setText("");
            }
            display.append("4");
        });
        five.setOnClickListener(v -> {
            if(display.getText().length() == 1 && "0".equals(display.getText())) {
                display.setText("");
            }
            display.append("5");
        });
        six.setOnClickListener(v -> {
            if(display.getText().length() == 1 && "0".equals(display.getText())) {
                display.setText("");
            }
            display.append("6");
        });
        one.setOnClickListener(v -> {
            if(display.getText().length() == 1 && "0".equals(display.getText())) {
                display.setText("");
            }
            display.append("1");
        });
        two.setOnClickListener(v -> {
            if(display.getText().length() == 1 && "0".equals(display.getText())) {
                display.setText("");
            }
            display.append("2");
        });
        three.setOnClickListener(v -> {
            if(display.getText().length() == 1 && "0".equals(display.getText())) {
                display.setText("");
            }
            display.append("3");
        });
        zero.setOnClickListener(v -> {
            if(display.getText().length() == 1 && "0".equals(display.getText())) {
                return;
            }
            display.append("0");
        });
    }

    private void acOperation() {
        operand1 = null;
        operand2 = null;
        display.setText("0");
    }
}