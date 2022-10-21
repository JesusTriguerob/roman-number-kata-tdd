package com.example.tdd.romannumber;

import java.util.Arrays;
import java.util.List;

public class RomanNumberUtil {

    private static final List<String> romanSimbols = Arrays.asList("I", "V", "X", "L", "C", "D", "M");

    public String parseToRoman(Integer naturalNumber) {
        char[] chartNumber = naturalNumber.toString().toCharArray();

        int increment = 0;
        String result = "";
        for (int i = chartNumber.length - 1; i >= 0; i--) {
            String roman = returnNumber(Character.getNumericValue(chartNumber[i]), increment, 1 + increment, 2 + increment);

            result = roman + result;
            increment += 2;
        }
        return result;

    }

    private String returnNumber(int naturalNumber, int x, int y, int z) {
        switch (naturalNumber) {
            case 4:
                return romanSimbols.get(x) + romanSimbols.get(y);
            case 9:
                return romanSimbols.get(x) + romanSimbols.get(z);
        }

        if (naturalNumber <= 3) {
            return addIorX(0, naturalNumber, "", romanSimbols.get(x));
        }

        if (naturalNumber <= 8) {
            return addIorX(5, naturalNumber, romanSimbols.get(y), romanSimbols.get(x));
        }

        return null;
    }

    private String addIorX(int numberInit, int naturalNumber, String initRomanNumber, String romanNumberIncrement) {
        StringBuilder initRomanNumberBld = new StringBuilder(initRomanNumber);

        for (int i = numberInit; i < naturalNumber; i++) {
            initRomanNumber = String.valueOf(initRomanNumberBld.append(romanNumberIncrement));
        }

        return initRomanNumber;
    }
}
