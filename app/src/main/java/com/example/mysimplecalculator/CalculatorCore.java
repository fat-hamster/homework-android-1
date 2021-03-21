package com.example.mysimplecalculator;

public class CalculatorCore {
    private Double operand1;
    private Double operand2;
    private Double result;
    private Boolean start;

    public CalculatorCore() {
        operand1 = null;
        operand2 = null;
        result = null;
        start = true;
    }

    public void reset() {
        operand1 = null;
        operand2 = null;
        result = null;
        start = true;
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

    public Double getResult(int op) {
        switch (op) {
            case 1: return sum();
            case 2: return sub();
            case 3: return mult();
            case 4: return div();
            case 5: return percent();
        }
        return result;
    }

    private Double sum() {
        if (result == null) {
            return operand1 + operand2;
        }
        return result + operand2;
    }

    private Double sub() {
        if (result == null) {
            return operand1 - operand2;
        }
        return result - operand2;
    }

    private Double mult() {
        if (result == null) {
            return operand1 * operand2;
        }
        return result * operand2;
    }

    private Double div() {
        if (result == null) {
            return operand1 / operand2;
        }
        return result / operand2;
    }

    private Double percent() {
        if (result == null) {
            return operand1 * (operand2 / 100);
        }
        return result * (operand2 / 100);
    }
}
