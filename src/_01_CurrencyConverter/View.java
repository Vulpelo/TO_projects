package com.vulpelo;

import java.util.Scanner;

public class View {
    private CurrencyCalculator currCalc;

    View() throws Exception {
        currCalc = new CurrencyCalculator();
    }

    void calculateValue(String fromCurrCode, String toCurrCode, float amount) {
        System.out.println(amount + " "  + fromCurrCode + " is " + currCalc.getResult(fromCurrCode, toCurrCode, amount) + " " + toCurrCode);
    }

    public CurrencyCalculator getCurrCalc() {
        return currCalc;
    }
}
