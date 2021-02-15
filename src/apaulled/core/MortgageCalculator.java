package apaulled.core;

import java.text.NumberFormat;

public class MortgageCalculator {
    public static double calculateMortgage(int principal, float annualInterest, byte period) {
        float r = annualInterest / 100 / 12;
        int n = period * 12;
        double mortgage = principal * (r * Math.pow(r + 1, n)) / (Math.pow(1 + r, n) - 1);
        return mortgage;
    }
}
