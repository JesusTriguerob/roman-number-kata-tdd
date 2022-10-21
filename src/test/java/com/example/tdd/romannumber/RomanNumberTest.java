package com.example.tdd.romannumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

class RomanNumberTest {

    private final RomanNumberUtil romanNumberUtil = new RomanNumberUtil();

    @ParameterizedTest
    @CsvSource({"1,I","2,II","3,III","4,IV","5,V","6,VI","7,VII","8,VIII","9,IX",
            "10,X","11,XI","12,XII","13,XIII","14,XIV","15,XV","16,XVI","17,XVII","18,XVIII","19,XIX",
            "20,XX","30,XXX","34,XXXIV","40,XL","50,L","60,LX","62,LXII","70,LXX","80,LXXX","90,XC",
            "200,CC","300,CCC","400,CD","500,D","692,DCXCII","984,CMLXXXIV","1200,MCC"
    })
    void parse_number_to_roman(int naturalNumber, String romanNumberExpected) {
        String romanNumber = romanNumberUtil.parseToRoman(naturalNumber);

        assertEquals(romanNumber, romanNumberExpected);
    }

}