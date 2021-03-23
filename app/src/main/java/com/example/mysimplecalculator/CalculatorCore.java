package com.example.mysimplecalculator;

import android.os.Parcel;
import android.os.Parcelable;

public class CalculatorCore implements Parcelable {
    private Double operand1;
    private Double operand2;
    private int operation;
    private Double result;
    private Boolean start;

    public CalculatorCore() {
        operand1 = null;
        operand2 = null;
        result = null;
        start = true;
        operation = 0;
    }

    private CalculatorCore(Parcel in) {
        double[] data = new double[4];
        in.readDoubleArray(data);
        result = data[0];
        operand1 = data[1];
        operand2 = data[2];
        operation = (int) data[3];
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public Double getOperand1() {
        return operand1;
    }

    public Double getOperand2() {
        return operand2;
    }

    public int getOperation() {
        return operation;
    }

    public void reset() {
        operand1 = null;
        operand2 = null;
        result = null;
        start = true;
        operation = 0;
    }

    public void addNumber(Double num) {
        if (operand1 != null && operand2 != null) {
            return;
        }
        if (start) {
            operand1 = num;
            start = false;
        } else {
            operand2 = num;
        }
    }

    public Double getResult() {
        switch (operation) {
            case 1: return sum();
            case 2: return sub();
            case 3: return mult();
            case 4: return div();
            case 5: return percent();
        }
        return result;
    }

    private Double sum() {
        return operand1 + operand2;
    }

    private Double sub() {
        return operand1 - operand2;
    }

    private Double mult() {
        return operand1 * operand2;
    }

    private Double div() {
        return operand1 / operand2;
    }

    private Double percent() {
        return operand1 * (operand2 / 100);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDoubleArray(new double[] {result, operand1, operand2, operation});
    }

    public static final Parcelable.Creator<CalculatorCore> CREATOR = new Parcelable.Creator<CalculatorCore>() {

        @Override
        public CalculatorCore createFromParcel(Parcel source) {
            return new CalculatorCore(source);
        }

        @Override
        public CalculatorCore[] newArray(int size) {
            return new CalculatorCore[size];
        }
    };
}
