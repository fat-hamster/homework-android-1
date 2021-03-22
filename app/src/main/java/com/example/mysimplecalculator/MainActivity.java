package com.example.mysimplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int operation = 0;
    private TextView display;
    private Boolean negative = false;
    private Boolean res = false;
    private CalculatorCore calc = new CalculatorCore();

    /* Code operations
        1 - plus
        2 - minus
        3 - multiply
        4 - divide
        5 - percent
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            if ("0".equals(display.getText().toString()) || res) {
                display.setText("");
                res = false;
            }
            display.append("7");
        });
        eight.setOnClickListener(v -> {
            if ("0".equals(display.getText().toString()) || res) {
                display.setText("");
                res = false;
            }
            display.append("8");
        });
        nine.setOnClickListener(v -> {
            if ("0".equals(display.getText().toString()) || res) {
                display.setText("");
                res = false;
            }
            display.append("9");
        });
        four.setOnClickListener(v -> {
            if ("0".equals(display.getText().toString()) || res) {
                display.setText("");
                res = false;
            }
            display.append("4");
        });
        five.setOnClickListener(v -> {
            if ("0".equals(display.getText().toString()) || res) {
                display.setText("");
                res = false;
            }
            display.append("5");
        });
        six.setOnClickListener(v -> {
            if ("0".equals(display.getText().toString()) || res) {
                display.setText("");
                res = false;
            }
            display.append("6");
        });
        one.setOnClickListener(v -> {
            if ("0".equals(display.getText().toString()) || res) {
                display.setText("");
                res = false;
            }
            display.append("1");
        });
        two.setOnClickListener(v -> {
            if ("0".equals(display.getText().toString()) || res) {
                display.setText("");
                res = false;
            }
            display.append("2");
        });
        three.setOnClickListener(v -> {
            if ("0".equals(display.getText().toString()) || res) {
                display.setText("");
                res = false;
            }
            display.append("3");
        });
        zero.setOnClickListener(v -> {
            if ("0".equals(display.getText().toString()) || res) {
                return;
            }
            display.append("0");
        });

        comma.setOnClickListener(v -> {
            if (display.getText().toString().contains(".") || res) {
                return;
            }
            display.append(".");
        });

        negativeSwitch.setOnClickListener(v -> negativeSwitch());
        plus.setOnClickListener(v -> plus());
        minus.setOnClickListener(v -> minus());
        multiply.setOnClickListener(v -> multiply());
        divide.setOnClickListener(v -> divide());
        equal.setOnClickListener(v -> calculate());
        percent.setOnClickListener(v -> percent());
    }

    private void acOperation() {
        calc.reset();
        negative = false;
        res = false;
        operation = 0;
        display.setText("0");
    }

    private void negativeSwitch() {
        if ("0".equals(display.getText())) {
            return;
        }
        negative = !negative;
        String val = display.getText().toString();
        if (negative) {
            display.setText("-");
            display.append(val);
        } else {
            display.setText(val.substring(1));
        }
    }

    private Double parseString(String val) {
        Double res = null;
        try {
            res = Double.parseDouble(val);
        } catch (ArithmeticException e) {
            // добавлю чуть позже
        }
        return res;
    }

    private void plus() {
        if (operation != 0) {
            return;
        }
        calc.addNumber(parseString(display.getText().toString()));
        operation = 1;
        display.setText("0");
    }

    private void minus() {
        if (operation != 0) {
            return;
        }
        calc.addNumber(parseString(display.getText().toString()));
        operation = 2;
        display.setText("0");
    }

    private void multiply() {
        if (operation != 0) {
            return;
        }
        calc.addNumber(parseString(display.getText().toString()));
        operation = 3;
        display.setText("0");
    }

    private void divide() {
        if (operation != 0) {
            return;
        }
        calc.addNumber(parseString(display.getText().toString()));
        operation = 4;
        display.setText("0");
    }

    private void percent() {
        if (operation != 0) {
            return;
        }
        calc.addNumber(parseString(display.getText().toString()));
        operation = 5;
        display.setText("0");
    }

    private void calculate() {
        if (operation == 0) {
            return;
        }
        try {
            calc.addNumber(Double.parseDouble(display.getText().toString()));
        } catch (NumberFormatException e) {
            // тут наверное нужна обработка. добавлю чуть позже вывод в лог
        }
        switch (operation) {
            case 1: displayResult(calc.getResult(1)); break;
            case 2: displayResult(calc.getResult(2)); break;
            case 3: displayResult(calc.getResult(3)); break;
            case 4: displayResult(calc.getResult(4)); break;
            case 5: displayResult(calc.getResult(5)); break;
        }
        operation = 0;
        res = true;
        calc.reset();
    }

    private void displayResult(Double res) {
        if (res == null) {
            display.setText("error");
            return;
        }
        String[] val = String.valueOf(res).split("\\.");
        if (val[1].length() == 1 && "0".equals(val[1])) {
            display.setText(val[0]);
        } else {
            display.setText(String.valueOf(res));
        }
    }
}