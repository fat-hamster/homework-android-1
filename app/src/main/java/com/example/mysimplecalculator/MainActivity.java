package com.example.mysimplecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private Boolean negative = false;
    private Boolean res = false;
    private CalculatorCore calc = new CalculatorCore();
    private final static String CalcValues = "CalcValues";

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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(CalcValues, calc);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        calc = instanceState.getParcelable(CalcValues);
        restoreDisplay();
    }

    private void restoreDisplay() {
        if(calc.getOperand2() != 0) {
            displayResult(calc.getResult());
            return;
        }
        if(calc.getOperand1() != 0 && calc.getOperation() == 0) {
            display.setText(String.valueOf(calc.getOperand1()));
        }
    }

    private void acOperation() {
        calc.reset();
        negative = false;
        res = false;
        display.setText(R.string.zero);
    }

    private void negativeSwitch() {
        if ("0".contentEquals(display.getText())) { //!!!! Проконтролировать !!!!
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
        if (calc.getOperation() != 0) {
            return;
        }
        calc.addNumber(parseString(display.getText().toString()));
        calc.setOperation(1);
        display.setText(R.string.zero);
    }

    private void minus() {
        if (calc.getOperation() != 0) {
            return;
        }
        calc.addNumber(parseString(display.getText().toString()));
        calc.setOperation(2);
        display.setText(R.string.zero);
    }

    private void multiply() {
        if (calc.getOperation() != 0) {
            return;
        }
        calc.addNumber(parseString(display.getText().toString()));
        calc.setOperation(3);
        display.setText(R.string.zero);
    }

    private void divide() {
        if (calc.getOperation() != 0) {
            return;
        }
        calc.addNumber(parseString(display.getText().toString()));
        calc.setOperation(4);
        display.setText(R.string.zero);
    }

    private void percent() {
        if (calc.getOperation() != 0) {
            return;
        }
        calc.addNumber(parseString(display.getText().toString()));
        calc.setOperation(5);
        display.setText(R.string.zero);
    }

    private void calculate() {
        if (calc.getOperation() == 0) {
            return;
        }
        calc.addNumber(Double.parseDouble(display.getText().toString()));

        displayResult(calc.getResult());

        res = true;
        calc.reset();
    }

    private void displayResult(Double res) {
        if (res == null) {
            display.setText(R.string.error);
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